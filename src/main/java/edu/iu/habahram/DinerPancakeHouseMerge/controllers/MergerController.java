package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {
    PancakeHouseRepository pancakeRepository;
    DinerRepository dinerRepository;

    public MergerController(PancakeHouseRepository pancakeRepository, DinerRepository dinerRepository) {
        this.pancakeRepository = pancakeRepository;
        this.dinerRepository = dinerRepository;
    }

    @GetMapping
    public MenuItem[] get() {
        List<MenuItem> pancakeMenu = pancakeRepository.getTheMenu();
        MenuItem[] dinerMenu = dinerRepository.getTheMenu();
        List<MenuItem> mergedMenu = new java.util.ArrayList<>(pancakeMenu);
        mergedMenu.addAll(Arrays.asList(dinerMenu));
        return mergedMenu.toArray(new MenuItem[0]);
    }
}
