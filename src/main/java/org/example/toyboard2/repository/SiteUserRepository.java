package org.example.toyboard2.repository;

import org.example.toyboard2.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {

}
