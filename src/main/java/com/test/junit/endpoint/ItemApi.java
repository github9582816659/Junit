package com.test.junit.endpoint;

import com.test.junit.model.Item;
import com.test.junit.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemApi {

    ItemService itemService;

    public ItemApi(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public Item save() {
        return Item.builder().id(1).name("Ball").price(10).quantity(100).build();
    }

    @GetMapping("/items-from-business")
    public Item saveUsingBusiness() {
        return itemService.findById(String.valueOf(1));
    }
}
