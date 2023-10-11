package com.example.huizenjacht.service;

import com.example.huizenjacht.model.House;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseListService {

    private List<Map<String, Object>> houses = new ArrayList<>();
    public void addHouse(House house) {
        Map<String, Object> temp = new HashMap<>();
        temp.put("code", house.getCode());
        temp.put("name", house.getName());
        temp.put("city", house.getCity());
        temp.put("price", house.getPrice());
        houses.add(temp);
    }

    public void updateHouse(String code, House house) {
        for (Map<String, Object> temp: houses) {
            if (temp.get("code").equals(code)){
                temp.replace("status", house.getStatus());
                temp.replace("name", house.getName());
                temp.replace("price", house.getPrice());
                break;
            }
        }
    }

    public List<Map<String, Object>> getHouses() {
        return houses;
    }

    public void deleteHouse(String code) {
        int counter = 0;
        boolean found = false;
        for (Map<String, Object> temp: houses) {
            if (code.equals(temp.get("code"))){
                found = true;
                break;
            }
            counter++;
        }
        if (found){
            houses.remove(counter);
        }
    }
}
