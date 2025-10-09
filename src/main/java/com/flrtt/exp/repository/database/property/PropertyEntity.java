package com.flrtt.exp.repository.database.property;

import com.flrtt.exp.repository.database.portal.PortalEntity;
import com.flrtt.exp.repository.database.user.UserEntity;
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
@Table(name = "properties")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String propertyId;
    String propertyName;
}