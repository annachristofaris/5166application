
import java.util.ArrayList;
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
public class UserDB {
    private static UserDB userDatabase = new UserDB();
    List<User> users;
    List<UserProfile> userProfiles;

    
    public UserDB(){
        users = new ArrayList<>();
        userProfiles = new ArrayList<>();
        
        //create default user
        User user1 = new User();
        user1.setUserID("jonsnow");
        user1.setFirstName("Jon");
        user1.setLastName("Snow");
        user1.setEmail("jonsnow@gmail.com");
        users.add(user1);
        
        
        
        //create UserProfile for default user and add two items to their list
        UserProfile profile1 = new UserProfile();
        profile1.setUser(user1);
        userProfiles.add(profile1);
        
//        ItemDB itemDatabase = ItemDB.getDatabase();
//        profile1.addItem(itemDatabase.getItem("splitlevel"), "four", true);
//        profile1.addItem(itemDatabase.getItem("besthouseplants"), "three", false);
   
        
    }
    
     public List<User> getUsers() {
        return users;
    }
     
     public List<UserProfile> getUserProfiles(){
        return userProfiles;
     }

    public static UserDB getUserDatabase() {
        return userDatabase;
    }
    
    public Item getItem(UserProfile userprofile, String itemCode) {
        Item temp = new Item();
        for (int i = 0; i < userProfiles.size(); i++) {
            if (userProfiles.get(i).equals(userprofile)) {
                for (int x = 0; x < userProfiles.get(i).itemList.size(); x++) {
                    if (userProfiles.get(i).itemList.get(x).getItem().getItemCode().equals(itemCode)) {
                temp = userProfiles.get(i).itemList.get(x).getItem();
                }
            }
        }
        }
        return temp;
    }
    
    public UserProfile getUserProfile(User currentUser) {
        UserProfile up = new UserProfile();
           for (int i = 0; i < userProfiles.size(); i++) {
               if (userProfiles.get(i).getUser().equals(currentUser)) {
                   up = userProfiles.get(i);
               }
           }
        return up;
    }
     

}
