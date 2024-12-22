package org.gfg.OrderService.service;

import org.gfg.OrderService.model.Order;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {




    public List<Order> fetchOrdersById(int id){

        Order o1 = new Order("Redmi Mobile", "This is REDMI Best Mobile",25000,new Date());
        Order o2 = new Order("iPhone Mobile", "This is latest iPhone",55000,new Date());
        Order o3 = new Order("DELL Laptop", "i9 Laptop",95000,new Date());
        Order o4 = new Order("Macbook air m3", "This is latest macbook",100000,new Date());

        if (id==1){
            return Arrays.asList(o1,o2);
        }else if (id==2){
            return Arrays.asList(o1,o3,o4);
        }
        else {
            return Arrays.asList(o1,o2,o3,o4);
        }
    }
}
