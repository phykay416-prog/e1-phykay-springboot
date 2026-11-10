package istad.com.restapi.repository;

import istad.com.restapi.model.User;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    private static List<User> usersData = List.of();
    public UserRepository(){
        User usr1 = new User(UUID.randomUUID(),"admin","wer","Administrator");
        User usr2 = new User(UUID.randomUUID(),"student","123","kay");
        User usr3 = new User(UUID.randomUUID(),"teacher","234","jojo");
        User usr4 = new User(UUID.randomUUID(),"housekeeping","234","ror");
        usersData = new ArrayList<>();
        usersData.add(usr1);
        usersData.add(usr2);
        usersData.add(usr3);
        usersData.add(usr4);
    }
    //Get all users

    public  List<User> select(){
        return usersData;
    }
    //Post - Insert new users
    public User insert(User user){
        usersData.add(user);
        return user;
    }
    public boolean updateFullName(UUID id, String fullName){
        for(int i = 0; i < usersData.size();i++){
            User user = usersData.get(i);
            if (user.id().equals(id)){
                User updatedUser = new User(
                        user.id(),
                        user.username(),
                        user.password(),
                        fullName
                );
                usersData.set(i, updatedUser);
                return true;
            }
        }
        return false;
    }
}


