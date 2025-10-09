package com.flrtt.exp.repository.database.property.portal;

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
@Table(name = "property_portals")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PropertyPortalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String propertyPortalId;
    String propertyId;
    String portalId;
}
