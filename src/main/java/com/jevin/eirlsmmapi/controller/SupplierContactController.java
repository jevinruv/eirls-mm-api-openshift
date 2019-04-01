package com.jevin.eirlsmmapi.controller;

import com.jevin.eirlsmmapi.model.SupplierContact;
import com.jevin.eirlsmmapi.repository.SupplierContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier-contacts")
public class SupplierContactController {

    @Autowired
    SupplierContactRepo repo;

    @GetMapping("/{id}")
    public Optional<SupplierContact> get(@PathVariable int id) {
        return repo.findById(id);
    }
    
    @GetMapping
    public List<SupplierContact> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public SupplierContact add(@RequestBody SupplierContact supplierContact) {
        return repo.save(supplierContact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repo.deleteById(id);
    }
}
