package com.example.huizenjacht.service;

import com.example.huizenjacht.model.House;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseListService {

    private Map<String, House> houses = new HashMap<>();
    public void addHouse(House house) {
        houses.put(house.getCode(), new House(house.getName(), house.getStatus(), house.getCity(), house.getPrice()));
    }

    public void updateHouse(String code, House house) {
        House flag = houses.get(code);
        if (flag != null){
            flag.setCity(house.getCity());
            flag.setName(house.getName());
            flag.setPrice(house.getPrice());
            flag.setStatus(house.getStatus());
        }
    }

    public Map<String, House> getHouses() {
        return houses;
    }

    public void deleteHouse(String code) {
        House flag = houses.get(code);
            if (flag != null){
                houses.remove(code);
            }
    }
}
