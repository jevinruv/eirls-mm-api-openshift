package com.jevin.eirlsmmapi.controller;

import com.jevin.eirlsmmapi.model.Supplier;
import com.jevin.eirlsmmapi.repository.SupplierRepo;
import com.jevin.eirlsmmapi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @Autowired
    SupplierRepo repo;

    @GetMapping("/{id}")
    public Optional<Supplier> get(@PathVariable int id) {
        return repo.findById(id);
    }

    @GetMapping
    public List<Supplier> getAll() {
        return repo.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('MM')")
    public ResponseEntity<?> addOrUpdate(@RequestBody Supplier supplier) {
        return supplierService.addOrUpdate(supplier);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MM') or hasRole('ADMIN')")
    public void delete(@PathVariable int id) {
        repo.deleteById(id);
    }
}
