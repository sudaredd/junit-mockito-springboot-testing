package app.unittesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@EqualsAndHashCode
public class Item {

   @Id
   private int id;

   private String name;
   private double price;
   private int quantity;

   @Transient
   private double value;

   public Item(int id, String name, double price, int quantity) {
      this.id = id;
      this.name = name;
      this.price = price;
      this.quantity = quantity;
   }

}
