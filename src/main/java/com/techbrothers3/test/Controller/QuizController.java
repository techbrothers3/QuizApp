package com.techbrothers3.test.Controller;

import com.techbrothers3.test.Model.CreateUser;
import com.techbrothers3.test.Model.Question;
import com.techbrothers3.test.Repository.QuestionRepository;
import com.techbrothers3.test.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    private Random random = new Random();

    @PostMapping("/start")
    public String startQuiz() {
        return "Quiz Session started!";
    }

    @GetMapping("/question")
    public Map<String,Object> getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            throw new RuntimeException("No questions available.");
        }
        Question question = questions.get(random.nextInt(questions.size()));
        Map<String, Object> response = new HashMap<>();
        response.put("id", question.getId());
        response.put("question", question.getQuestion());
        response.put("options", question.getOptions());
        return response;
    }

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam Long questionId, @RequestParam String answer, @RequestParam String username) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        if(optionalQuestion.isEmpty()) {
            return "Question Not Found";
        }
        Question question = optionalQuestion.get();
        CreateUser user = userRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("User not Found"));

        if(question.getCorrectAnswer().equalsIgnoreCase(answer)) {
            user.incrementCorrect();
            userRepository.save(user);
            return "Correct Answer";
        } else {
            user.incrementIncorrect();
            userRepository.save(user);
            return "Incorrect Answer. The correct answer is " + question.getCorrectAnswer();
        }
    }

    @GetMapping("/stats")
    public Map<String,Integer> getUserStats(@RequestParam String username) {
        CreateUser user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found."));
        Map<String,Integer> stats = new HashMap<>();
        stats.put("Total Answered", user.getTotalAnswered());
        stats.put("Correct Answers", user.getCorrectAnswers());
        stats.put("Incorrect Answers", user.getIncorrectAnswers());
        return stats;
    }


}
