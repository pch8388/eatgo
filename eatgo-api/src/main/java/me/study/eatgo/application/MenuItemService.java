package me.study.eatgo.application;

import me.study.eatgo.domain.MenuItem;
import me.study.eatgo.domain.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public void bulkUpdate(Long restaurantId, List<MenuItem> menuItems) {
        MenuItem menuItem = MenuItem.builder().build();
        menuItemRepository.save(menuItem);
    }

}
