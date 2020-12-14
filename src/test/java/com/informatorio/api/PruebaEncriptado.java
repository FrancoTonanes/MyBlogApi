package com.informatorio.api;

import com.informatorio.api.model.User;
import com.informatorio.api.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaEncriptado {

    @Autowired
    private UserService userService;

    @Test
    public void pruebaPass(){
        User user = new User();
        user.setPassword("Maxfire2");
        User retorno = userService.saveUser(user);
        assertTrue(retorno.getPassword().equalsIgnoreCase(user.getPassword()));
    }
}
