package com.flrtt.exp.repository.database.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);

    @Query("""
        SELECT
                u.userId as userId,
                u.username as username,
                u.password as password,
                u.role as role,
                p.propertyName as propertyName,
                up.propertyId as propertyId,
                pe.portalId as portalId,
                pe.portalName as portalName
            FROM UserEntity u
            JOIN UserPropertyEntity up ON u.userId = up.userId
            JOIN PropertyEntity p ON up.propertyId = p.propertyId
            JOIN PropertyPortalEntity ppe ON p.propertyId = ppe.propertyId
            JOIN PortalEntity pe ON ppe.portalId = pe.portalId
    """)
    List<UserProjection> findPortalByUsername();

    public interface UserProjection {
        String getUserId();
        String getUsername();
        String getPassword();
        String getRole();
        String getPropertyId();
        String getPropertyName();
        String getPortalId();
        String getPortalName();
    }
}
