
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author annachristofaris
 */
public class UserProfile implements Serializable {

    User user;
    List<UserItem> itemList;
    // String UserID="";

    public UserProfile() {
        itemList = new ArrayList<>();
    }

    public UserProfile(User user) {
        this.user = user;
        itemList = new ArrayList<>();
        //  UserID = this.user.getUserID();
    }
//    getters and setters

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public List<UserItem> getItemList() {
        return itemList;
    }

    // methods to add, remove, and update items and lists
    public void addItem(Item item, String rating, Boolean madeIt) {
        boolean exists = false;
        for (int i = 0; i < itemList.size(); i++) {
            //check if profile already contains this item
            if (itemList.get(i).getItem() == item) {
                exists = true;
                //if iteam exists, update rating and "made it" for that iteam
                itemList.get(i).setRating(rating);
                itemList.get(i).setMadeIt(madeIt);
                break;
            }
        }

        // add new userItem if it wasn't in the list
        if (!exists) {
            UserItem userItem = new UserItem();
            userItem.setItem(item);
            userItem.setRating(rating);
            userItem.setMadeIt(madeIt);
            this.itemList.add(userItem);
        }

//        // check list to see if userItem exists, only creating a new item if it doesn't
//        if (!itemList.contains(item)) {
//        item = new UserItem();
//        }
//        // update new or existing userItem
//        item.setRating(rating);
//        item.setMadeIt(madeIt);
    }

    public void addItem(UserItem item) {
        // check list to see if userItem is already in list before adding
        if (!(itemList.contains(item))) {
            itemList.add(item);
        } else {
            //do something here if item is already in list
        }
    }

    public void removeItem(Item item) {
        //using an iterator to go through UserItem list and remove associated item(s)
        Iterator<UserItem> itr = itemList.iterator();
        while (itr.hasNext()) {
            UserItem currentItem = itr.next();
            if (currentItem.getItem() == item) {
                itr.remove();
            }
        }
    }

    public void updateItem(UserItem item, String rating, boolean madeIt) {
        Iterator<UserItem> itr = itemList.iterator();
        while (itr.hasNext()) {
            UserItem currentItem = itr.next();
            if (currentItem == item) {
                currentItem.setRating(rating);
                currentItem.setMadeIt(madeIt);
            }
        }
    }

    public void updateItem(Item item, String rating, boolean madeIt) {
        Iterator<UserItem> itr = itemList.iterator();
        while (itr.hasNext()) {
            UserItem currentItem = itr.next();
            if (currentItem.getItem() == item) {
                currentItem.setRating(rating);
                currentItem.setMadeIt(madeIt);
            }
        }
    }

    public List<UserItem> getItems() {
        return itemList;
    }

    public void emptyProfile() {
        itemList.clear();
    }

    public Item getItem(String itemCode) {
        Item temp = new Item();
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItem().getItemCode().equals(itemCode)) {
                itemList.get(i).getItem();
            }
        }
        return temp;
    }

    public Item findItemInDB(String itemCode) {
        ItemDB database = ItemDB.getDatabase();
        Item newItem = database.getItem(itemCode);
        return newItem;
    }

    public boolean isInList(Item item) {
        boolean exists = false;
        for (int i = 0; i < itemList.size(); i++) {
            //check if profile already contains this item
            if (itemList.get(i).getItem() == item) {
                exists = true;
            } else {
                exists = false;
            }
        }
        return exists;
    }
}
