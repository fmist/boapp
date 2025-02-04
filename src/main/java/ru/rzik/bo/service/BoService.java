package ru.rzik.bo.service;

import org.springframework.http.ResponseEntity;
import ru.rzik.bo.model.Bo;

import java.util.List;

public interface  BoService {

    List<Bo> getAllBos();

    ResponseEntity<?> getBoById(Long id);

    Bo saveBo(Bo bo);

    ResponseEntity<?> editBo(Long id, Bo bo);

    ResponseEntity<?> deleteBo(Long id);

    void deleteAllBos();

}
