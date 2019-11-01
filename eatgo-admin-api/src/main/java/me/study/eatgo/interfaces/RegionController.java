package me.study.eatgo.interfaces;

import me.study.eatgo.domain.Region;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RegionController {

    @GetMapping("/regions")
    public List<Region> list() {
        List<Region> regions = new ArrayList<>();
        regions.add(Region.builder().name("Seoul").build());

        return regions;
    }
}
