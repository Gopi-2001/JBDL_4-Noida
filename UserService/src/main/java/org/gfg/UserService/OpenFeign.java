package org.gfg.UserService;

import org.gfg.UserService.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "OrderService")
public interface OpenFeign {

    @GetMapping("/fetch/order/user/{uid}")
    public List<Order> fetchOrdersBYUserId(@PathVariable("uid") String id);
}
