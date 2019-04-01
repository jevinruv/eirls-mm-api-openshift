package com.jevin.eirlsmmapi.service;

import com.jevin.eirlsmmapi.model.Supplier;
import com.jevin.eirlsmmapi.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    SupplierRepo repo;

    public ResponseEntity<?> addOrUpdate(Supplier supplier) {

        supplier.getSupplierContact().setSupplier(supplier);
        repo.save(supplier);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

}
