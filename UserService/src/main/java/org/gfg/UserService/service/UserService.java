package org.gfg.UserService.service;

import org.gfg.UserService.OpenFeign;
import org.gfg.UserService.model.Order;
import org.gfg.UserService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OpenFeign openFeign;

   static List<User> user = new ArrayList<>();

    static {
        user.add(new User(1, "Robin", "robin@Gmail.com",null));
        user.add(new User(2, "Aakash", "aaksh@Gmail.com",null));
        user.add(new User(3, "Daksh", "daksh@Gmail.com",null));
    }


    public User getUser(int id){
        User actualUser=null;
        for (User u: user){
            if (u.getId()==id){
                actualUser = u;
                break;
            }
        }
        if (actualUser==null){
            return null;
        }

      //  List<Order> orderList = restTemplate.getForObject("http://localhost:8082/orders/fetch/order/user/"+id, List.class);
        List<Order> orderList = openFeign.fetchOrdersBYUserId(""+id);
        actualUser.setOrderList(orderList);

        return actualUser;
    }
}
