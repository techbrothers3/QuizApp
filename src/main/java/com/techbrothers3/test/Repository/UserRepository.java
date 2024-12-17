package com.techbrothers3.test.Repository;

import com.techbrothers3.test.Model.CreateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CreateUser,Long> {
    Optional<CreateUser> findByUsername(String username);
}
