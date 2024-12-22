package org.gfg.UserService.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/postal/info/{pincode}")
    public List<String> getPostOfficeInfo(@PathVariable("pincode") String pin){
       String ans = restTemplate.getForObject("https://api.postalpincode.in/pincode/"+pin,String.class);
        List<String> ansList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(ans);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        JSONArray postOfficeArray = jsonObject.getJSONArray("PostOffice");

        for (int i=0;i<postOfficeArray.length();i++){
            JSONObject postObject = postOfficeArray.getJSONObject(i);
            String name = postObject.getString("Name");
            String district = postObject.getString("District");
            ansList.add(name+" : "+district);
        }

       return ansList;

    }
}
