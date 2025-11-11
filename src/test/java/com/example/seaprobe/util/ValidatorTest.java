package com.example.seaprobe.util;

import com.example.seaprobe.dto.Coordinate;
import com.example.seaprobe.dto.Grid;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
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
        Set<Coordinate> obstacle = Set.of(new Coordinate(1,2),
                new Coordinate(4,2));
        Coordinate invalidCoordinate = new Coordinate(4,2);
        assertFalse(Validator.notAnObstacle(obstacle, invalidCoordinate));
    }
    @Test
    void testValidCoordinates_true(){
        Grid grid = new Grid(0,5,0,5);
        Coordinate coordinate = new Coordinate(2,3);
        assertTrue(Validator.validateCoordinates(grid, coordinate));
    }
    @Test
    void testNotAnObstacle_true(){
        Set<Coordinate> obstacle = Set.of(new Coordinate(1,2),
                new Coordinate(4,2));
        Coordinate validCoordinate = new Coordinate(2,2);
        assertTrue(Validator.notAnObstacle(obstacle, validCoordinate));
    }
}