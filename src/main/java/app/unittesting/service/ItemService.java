package app.unittesting.service;

import app.unittesting.data.ItemRepository;
import app.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

  @Autowired private ItemRepository itemRepository;

  public Item getItem() {
    return itemRepository.findById(1).get();
  }

  public List<Item> finalAllItems() {
    List<Item> items = itemRepository.findAll();
    items.forEach(item -> item.setValue(item.getPrice() * item.getQuantity()));
    return items;
  }
}
