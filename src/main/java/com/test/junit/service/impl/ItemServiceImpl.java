package com.test.junit.service.impl;

import com.test.junit.model.Item;
import com.test.junit.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public Item findById(String id) {
        return Item.builder().id(1).name("Ball").price(10).quantity(100).build();
    }
}
