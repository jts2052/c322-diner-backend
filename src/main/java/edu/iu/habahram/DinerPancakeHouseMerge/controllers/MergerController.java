package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    DinerRepository dinerRepository;
    PancakeHouseRepository pancakeHouseRepository;

    public MergerController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }

    @GetMapping
    public List<MenuItem> get() {
        List<MenuItem> menuItems = new ArrayList<>();
        Iterator<MenuItem> dinerMenuIterator = dinerRepository.getTheMenuIterator();
        Iterator<MenuItem> pancakeHouseMenuIterator = pancakeHouseRepository.getTheMenuIterator();
        Iterator<MenuItem> cafeMenuIterator = dinerRepository.getTheMenuIterator();

        while (dinerMenuIterator.hasNext()) {
            menuItems.add(dinerMenuIterator.next());
        }

        while (pancakeHouseMenuIterator.hasNext()) {
            menuItems.add(pancakeHouseMenuIterator.next());
        }

        while (cafeMenuIterator.hasNext()) {
            menuItems.add(cafeMenuIterator.next());
        }

        return menuItems;
    }
}