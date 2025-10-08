package com.flrtt.exp.repository.database.user;

import com.flrtt.exp.repository.database.property.PropertyEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String userId;
    String username;
    String password;
    String role;
}