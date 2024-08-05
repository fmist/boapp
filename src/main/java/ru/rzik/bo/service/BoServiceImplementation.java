package ru.rzik.bo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.rzik.bo.model.Bo;
import ru.rzik.bo.repository.BoRepository;
import java.util.List;
import java.util.UUID;

@Service
public class BoServiceImplementation implements BoService {

    private final BoRepository boRepository;

    public BoServiceImplementation(BoRepository boRepository) {
        this.boRepository = boRepository;
    }
    @Override
    public List<Bo> getAllBos() {
        return boRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getBoById(UUID id) {
        try {
            Bo bo = boRepository.findById(id).orElseThrow();
            return ResponseEntity.ok().body(bo);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Id " + id + " not found");
        }
    }

    @Override
    public Bo saveBo(Bo bo) {
        return boRepository.save(bo);
    }

    @Override
    public Bo editBo(UUID id, Bo bo) {
        Bo newBo = boRepository.findById(id).orElseThrow();
        newBo.setId(id);
        newBo.setName(bo.getName());
        newBo.setDescription(bo.getDescription());
        return boRepository.save(newBo);
    }

    @Override
    public ResponseEntity<?> deleteBo(@PathVariable UUID id) {
        if (boRepository.existsById(id)) {
            boRepository.deleteById(id);
            return ResponseEntity.ok().body("Id " + id + " deleted");
        } else {
            return ResponseEntity.status(404).body("Id " + id + " not found");
        }
    }
}
