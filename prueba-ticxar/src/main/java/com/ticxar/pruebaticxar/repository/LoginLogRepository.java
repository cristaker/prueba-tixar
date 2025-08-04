package com.ticxar.pruebaticxar.repository;

import com.ticxar.pruebaticxar.models.entities.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoginLogRepository extends JpaRepository<LoginLog, UUID> {
}
