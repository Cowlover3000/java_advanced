package com.example.huizenjacht.api;

import com.example.huizenjacht.model.House;
import com.example.huizenjacht.service.HouseListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/houses")
@RestController
public class HouseListServiceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HouseListServiceController.class);
    private final HouseListService houseListService;

    public HouseListServiceController(HouseListService houseListService) {
        this.houseListService = houseListService;
    }


    @PostMapping
    public void addHouse(@RequestBody House house){
        LOGGER.info(house.getName());
        houseListService.addHouse(house);
    }

    @PutMapping("/{code}")
    public void updateHouse(@PathVariable String code, @RequestBody House house){
        houseListService.updateHouse(code, house);
    }

    @GetMapping
    public Map<String, House> getHouses(){
        return houseListService.getHouses();
    }

    @DeleteMapping("/{code}")
    public void deleteHouse(@PathVariable String code){
        houseListService.deleteHouse(code);
    }
}
