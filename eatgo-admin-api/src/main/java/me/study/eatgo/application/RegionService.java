package me.study.eatgo.application;

import me.study.eatgo.domain.Region;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {
    public List<Region> getRegions() {
        List<Region> regions = new ArrayList<>();
        regions.add(Region.builder().name("Seoul").build());
        return regions;
    }
}
