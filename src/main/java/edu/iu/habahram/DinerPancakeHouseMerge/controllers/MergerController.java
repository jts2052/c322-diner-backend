package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
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
    CafeRepository cafeRepository;
    MergerRepository mergerRepository;

    public MergerController(DinerRepository dinerRepository,
                            PancakeHouseRepository pancakeHouseRepository,
                            CafeRepository cafeRepository,
                            MergerRepository mergerRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
        this.cafeRepository = cafeRepository;
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItem> get() {
        ArrayList<Menu> menus = mergerRepository.getTheMenus();
        List<MenuItem> menuItems = new ArrayList<>();

        for (Menu menu : menus) {
            Iterator<MenuItem> iterator = menu.createIterator();
            while (iterator.hasNext()) {
                menuItems.add(iterator.next());
            }
        }

        return menuItems;
    }
}