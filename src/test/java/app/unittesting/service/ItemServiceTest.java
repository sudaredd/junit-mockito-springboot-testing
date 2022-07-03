package app.unittesting.service;

import app.unittesting.data.ItemRepository;
import app.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

  @InjectMocks private ItemService itemService;

  @Mock private ItemRepository itemRepository;

  @Test
  void getItem() {

    var ball = new Item(1, "Cricket Ball", 56.45, 2);
    when(itemRepository.findById(1)).thenReturn(Optional.of(ball));
    assertEquals(ball, itemService.getItem());
  }

  @Test
  void finalAllItems() {

    var items = List.of(
        new Item(1, "Cricket Ball", 56.45, 2),
        new Item(1, "Tennis Ball", 30, 20)
    );

    when(itemRepository.findAll()).thenReturn(items);

    var expectedItems = List.of(
        new Item(1, "Cricket Ball", 56.45, 2),
        new Item(1, "Tennis Ball", 30, 20)
    );

    expectedItems.forEach(item -> item.setValue(item.getPrice() * item.getQuantity()));

    assertEquals(expectedItems, itemService.finalAllItems());

    assertEquals(112.9, itemService.finalAllItems().get(0).getValue());
    assertEquals(600, itemService.finalAllItems().get(1).getValue());

  }
}
