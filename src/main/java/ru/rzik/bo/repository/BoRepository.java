package ru.rzik.bo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rzik.bo.model.Bo;

import java.util.UUID;

public interface BoRepository extends JpaRepository<Bo, UUID> {
}
