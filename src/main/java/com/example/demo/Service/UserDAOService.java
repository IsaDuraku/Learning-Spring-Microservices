package com.example.demo.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.example.demo.Model.User;
import org.springframework.stereotype.Component;

@Component

public class UserDAOService {
    private static ArrayList<User> users = new ArrayList();
    private static int usersCount = 3;


    static{
        users.add(new User(1,"Isa, " , new Date()));
        users.add(new User(2,"Shabani, " , new Date()));
        users.add(new User(3,"Ramadani, " , new Date()));
    }
    public List<User> findAll(){
        return users;
    }
    public User saveUser(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }
    public User findOne(int id){
        for(User users: users){
            if(users.getId() == id){
                return users;
            }
        }
        return null;
    }
    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
            iterator.remove();
            return user;
            }
        }
        return null;
    }
}
