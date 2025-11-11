package com.example.seaprobe.util;

import com.example.seaprobe.dto.Coordinate;
import com.example.seaprobe.dto.Grid;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidatorTest {

    @Test
    void testValidCoordinates_OutOfBound_false() {
        Grid grid = new Grid(0,5,0,5);
        Coordinate coordinate = new Coordinate(6,3);
        assertFalse(Validator.validateCoordinates(grid,coordinate));
    }
    @Test
    void testNotAnObstacle_false(){
        Set<Coordinate> obstacle = new HashSet<>();
        obstacle.add(new Coordinate(2,2));
        Coordinate coordinate = new Coordinate(3,3);
        assertFalse(Validator.notAnObstacle(obstacle, coordinate));
    }
}