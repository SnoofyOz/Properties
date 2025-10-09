package com.flrtt.exp.repository.database.user.property;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_properties")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserPropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String userPropertyId;
    String userId;
    String propertyId;
}
