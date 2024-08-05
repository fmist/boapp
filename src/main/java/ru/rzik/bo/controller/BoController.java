package ru.rzik.bo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rzik.bo.model.Bo;
import ru.rzik.bo.service.BoService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping()
public class BoController {

    BoService boService;

    public BoController(BoService boService) {
        this.boService = boService;
    }

    @GetMapping
    private List<Bo> getAll() {
        return boService.getAllBos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable UUID id) {
        return boService.getBoById(id);
    }

    @PostMapping("/add")
    private ResponseEntity<Bo> add(@RequestBody Bo bo) throws URISyntaxException {
        Bo savedBo = boService.saveBo(bo);
        return ResponseEntity.created(new URI("/" + savedBo.getId()))
                .body(savedBo);
    }

    @PutMapping("/edit/{id}")
    private Bo update(@PathVariable UUID id, @RequestBody Bo bo) {
        return boService.editBo(id, bo);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable UUID id) {
        return boService.deleteBo(id);
    }
}
