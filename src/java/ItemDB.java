/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author annachristofaris
 */

import java.util.ArrayList;
import java.util.Arrays;



public class ItemDB {
    private static ItemDB database = new ItemDB();
    ArrayList<Item> items;

    public ItemDB(){
        items = new ArrayList<Item>();
        Item item1 = new Item();
        item1.setTitle("5 Foolproof Decor Tips");
        item1.setCategory("tips");
        item1.setDesc("Description for " + item1.getTitle());
        item1.setItemCode("5foolprooftips");
        items.add(item1);


        Item item2 = new Item();
        item2.setTitle("The Best (and easiest!) Houseplants to Liven Up Your Space");
        item2.setCategory("popular");
        item2.setDesc("Description for " + item2.getTitle());
        item2.setItemCode("besthouseplants");
        items.add(item2);

        Item item3 = new Item();
        item3.setTitle("Before & After: Kitchen Renovation");
        item3.setCategory("popular");
        item3.setDesc("Description for " + item3.getTitle());
        item3.setItemCode("kitchenreno");
        items.add(item3);

        Item item4 = new Item();
        item4.setTitle("How-to: Restore Wood Furniture");
        item4.setCategory("tips");
        item4.setDesc("Description for " + item4.getTitle());
        item4.setItemCode("restorewood");
        items.add(item4);

        Item item5 = new Item();
        item5.setTitle("Inside a Split-Level Seattle Home");
        item5.setCategory("popular");
        item5.setDesc("Description for " + item5.getTitle());
        item5.setItemCode("splitlevel");
        items.add(item5);

        Item item6 = new Item();
        item6.setTitle("Maximizing a Small Space");
        item6.setCategory("tips");
        item6.setDesc("Description for " + item6.getTitle());
        item6.setItemCode("smallspace");
        items.add(item6);
     
    }
    
        
    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItem(String itemCode) {
        Item temp = new Item();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemCode().equals(itemCode)) {
                temp = items.get(i);
            }
        }
        return temp;
    }
    
    public ArrayList<Item> getItemsByCategory(String category) {
        ArrayList<Item> items = new ArrayList<>();
        for (Item i : getItems()) {
            if (i.getCategory().equals(category)) {
                items.add(i);
            }
        }
        return items;

    }
      public static ItemDB getDatabase() {
        return database;
    }
    
    


}

    

