package com.jevin.eirlsmmapi.service;

import com.jevin.eirlsmmapi.model.Item;
import com.jevin.eirlsmmapi.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepo repo;

    public ResponseEntity<?> addOrUpdate(Item item) {

        item.getItemReorder().setItem(item);
        repo.save(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
