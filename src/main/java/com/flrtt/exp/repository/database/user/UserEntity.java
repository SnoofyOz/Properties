package com.flrtt.exp.repository.database.user;

import com.flrtt.exp.repository.database.property.PropertyEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String username;
    String password;
    String role;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_property",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "property_id")
    )
    Set<PropertyEntity> properties;
}