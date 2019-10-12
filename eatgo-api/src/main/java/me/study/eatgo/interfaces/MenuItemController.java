package me.study.eatgo.interfaces;

import me.study.eatgo.application.MenuItemService;
import me.study.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItemService.bulkUpdate(menuItems);
        return "";
    }
}
