package app.unittesting.controller;

import app.unittesting.model.Item;
import app.unittesting.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostConstruct
    public void init() {
        log.info("at ItemController init()");
    }

    @GetMapping("/item")
    public Item getItem() {
        return itemService.getItem();
    }

    @GetMapping("/all-items")
    public List<Item> getAllItems() {
        return itemService.finalAllItems();
    }
}
