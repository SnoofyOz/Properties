package com.flrtt.exp.repository.database.portal;

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
@Table(name = "portals")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class PortalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String portalId;
    String portalName;
    String description;
}