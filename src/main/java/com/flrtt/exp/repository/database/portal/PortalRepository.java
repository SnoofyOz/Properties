package com.flrtt.exp.repository.database.portal;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalRepository extends JpaRepository<PortalEntity, String> {
}
