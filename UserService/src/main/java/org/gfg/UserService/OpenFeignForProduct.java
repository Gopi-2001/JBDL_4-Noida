package org.gfg.UserService;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "PRODUCTSERVICE")
public interface OpenFeignForProduct {
}
