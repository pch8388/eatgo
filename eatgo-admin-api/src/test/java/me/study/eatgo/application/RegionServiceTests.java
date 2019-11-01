package me.study.eatgo.application;

import me.study.eatgo.domain.Region;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RegionServiceTests {

    private RegionService regionService;

    @Before
    public void setUp() {
        regionService = new RegionService();
    }

    @Test
    public void getRegions() {
        List<Region> regions = regionService.getRegions();

        Region region = regions.get(0);
        assertThat(region.getName(), is("Seoul"));
    }

}