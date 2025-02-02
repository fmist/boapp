package ru.rzik.bo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rzik.bo.model.Bo;
import ru.rzik.bo.service.BoService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8083"})
@RequiredArgsConstructor
public class BoController {

    private final BoService boService;

    @GetMapping
    private List<Bo> getAll() {
        return boService.getAllBos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        return boService.getBoById(id);
    }

    @PostMapping("/add")
    private ResponseEntity<Bo> add(@RequestBody Bo bo) throws URISyntaxException {
        Bo savedBo = boService.saveBo(bo);
        return ResponseEntity.created(new URI("/" + savedBo.getId()))
                .body(savedBo);
    }

    @PutMapping("/edit/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody Bo bo) {
        return boService.editBo(id, bo);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        return boService.deleteBo(id);
    }

    @DeleteMapping("/clear")
    private ResponseEntity<?> clear() {
        boService.deleteAllBos();
        return new ResponseEntity<>("List cleared", HttpStatus.NO_CONTENT);
    }
}
