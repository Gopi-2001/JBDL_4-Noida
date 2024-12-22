package org.gfg.OrderService.controller;

import org.gfg.OrderService.model.Order;
import org.gfg.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/fetch/order/user/{uid}")
    public List<Order> fetchOrdersBYUserId(@PathVariable("uid") String id){
        int oid = Integer.parseInt(id);
        return orderService.fetchOrdersById(oid);
    }
}
