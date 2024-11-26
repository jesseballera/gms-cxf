package com.purplemango.gms.repository;

import com.purplemango.gms.gen.StatusType;
import com.purplemango.gms.gen.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserRepository {

    private static final Map<String, User> userMap = new HashMap<String, User>();

    @PostConstruct
    public void initData() {
        User user = new User();
        user.setUsername("boboy");
        user.setFirstname("Michael");
        user.setLastname("Doggo");
        user.setEmail("michael@doggo.com");
        user.setPassword("password");
        user.setStatus(StatusType.ACTIVE);

        userMap.put(user.getUsername(), user);

        User user1 = new User();
        user1.setUsername("giri");
        user1.setFirstname("Michelle");
        user1.setLastname("Doggo");
        user1.setEmail("michelle@doggo.com");
        user1.setPassword("password");
        user1.setStatus(StatusType.ACTIVE);

        userMap.put(user1.getUsername(), user1);

        User user2 = new User();
        user2.setUsername("bololok");
        user2.setFirstname("Toffee");
        user2.setLastname("Doggo");
        user2.setEmail("toffee@doggo.com");
        user2.setPassword("password");
        user2.setStatus(StatusType.ACTIVE);

        userMap.put(user2.getUsername(), user2);
    }

    public Collection<User> getAllUsers() {
        return userMap.values();
    }

    public User getUsersByUsername(String username) {
        Assert.notNull(username, "Username cannot be null");
        return userMap.get(username);
    }
}
