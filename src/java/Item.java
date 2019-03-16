
import java.io.Serializable;

/**
 *
 * @author annachristofaris
 */
public class Item implements Serializable {
    private String itemCode, itemName, category, title, desc, rating, imageURL;

    public Item() {
        itemCode ="";
        itemName="";
        category="";
        title="";   
        desc="";
        rating = "4";
        imageURL = "";
    }
    
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
        this.imageURL = "./images/" + itemCode + ".png";
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImageURL() {
      String newUrl = "./images/" + itemCode + ".png";
        return newUrl;
    }
}

