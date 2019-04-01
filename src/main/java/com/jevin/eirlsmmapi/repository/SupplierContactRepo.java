package com.jevin.eirlsmmapi.repository;

import com.jevin.eirlsmmapi.model.SupplierContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierContactRepo extends JpaRepository<SupplierContact, Integer> {
}
