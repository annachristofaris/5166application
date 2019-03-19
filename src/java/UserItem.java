
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author annachristofaris
 */
public class UserItem implements Serializable {
    public Item item; 
    String rating; 
    boolean madeIt;
    
    public UserItem() {
       rating = "";  
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean isMadeIt() {
        return madeIt;
    }

    public void setMadeIt(boolean madeIt) {
        this.madeIt = madeIt;
    }
    

    

    
    
}
