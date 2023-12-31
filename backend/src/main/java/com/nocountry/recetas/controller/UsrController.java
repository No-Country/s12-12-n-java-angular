package com.nocountry.recetas.controller;

import com.nocountry.recetas.domain.request.UsrRequest;
import com.nocountry.recetas.service.UsrService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsrController {

    private final UsrService service;

    @GetMapping("/users")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        var response = service.findById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/users")
    public ResponseEntity<?> save(@Valid @RequestBody UsrRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    /*@PutMapping("/users/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody UsrRequest request, @PathVariable Long id) {
        var user = service.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }*/

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        var user = service.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
