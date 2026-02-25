package com.example.reclamationweb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name= "UserMS4TWIN1", configuration = FeignConfig.class)

public interface UserClient {
    @RequestMapping("/users")
    public List<User> getUsers();
    @RequestMapping("/users/[id]")
    public User getUser(@PathVariable int id);


}
