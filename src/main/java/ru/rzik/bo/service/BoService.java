package ru.rzik.bo.service;

import org.springframework.http.ResponseEntity;
import ru.rzik.bo.model.Bo;
import java.util.List;
import java.util.UUID;

public interface BoService {
    List<Bo> getAllBos();
    ResponseEntity<?> getBoById(UUID id);
    Bo saveBo(Bo bo);
    ResponseEntity<?> editBo(UUID id, Bo bo);
    ResponseEntity<?> deleteBo(UUID id);
    void deleteAllBos();
}
