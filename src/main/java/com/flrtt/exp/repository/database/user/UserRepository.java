package com.flrtt.exp.repository.database.user;

import com.flrtt.exp.dto.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);

    @Query("""
        SELECT u
        FROM UserEntity u
        JOIN UserPropertyEntity up ON u.userId = up.userId
    """)
    List<User> findByUsernameDetails();
}
