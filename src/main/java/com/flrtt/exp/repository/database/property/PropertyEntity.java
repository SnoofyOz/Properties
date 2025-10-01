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
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String propertyname;

    @ManyToMany(mappedBy = "properties")
    Set<UserEntity> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "property_portal",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "portal_id")
    )
    private Set<PortalEntity> portals;
}