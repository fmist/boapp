package ru.rzik.bo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.rzik.bo.exception.BoException;
import ru.rzik.bo.model.Bo;
import ru.rzik.bo.repository.BoRepository;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> getBoById(@PathVariable Long id) {
        Optional<Bo> bo = boRepository.findById(id);
        if (bo.isEmpty()) {
            throw new BoException("Id " + id + " not found");
        }
        return ResponseEntity.ok().body(bo);
    }

    @Override
    public Bo saveBo(Bo bo) {
        return boRepository.save(bo);
    }

    @Override
    public ResponseEntity<?> editBo(Long id, Bo bo) {
        if (boRepository.existsById(id)) {
            Bo newBo = boRepository.findById(id).orElseThrow();
            newBo.setName(bo.getName());
            newBo.setDescription(bo.getDescription());
            return new ResponseEntity<>(boRepository.save(newBo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(boRepository.save(bo), HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<?> deleteBo(@PathVariable Long id) {
        if (boRepository.existsById(id)) {
            boRepository.deleteById(id);
            return ResponseEntity.ok().body("Id " + id + " deleted");
        } else {
            return ResponseEntity.status(404).body("Id " + id + " not found");
        }
    }

    @Override
    public void deleteAllBos() {
        boRepository.deleteAll();
    }
}
