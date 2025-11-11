package com.example.seaprobe.util;

import com.example.seaprobe.dto.Coordinate;
import com.example.seaprobe.dto.Grid;

import java.util.Set;

public class Validator {
    public static  boolean validateCoordinates(Grid grid, Coordinate coordinate) {
        return false;
    }
    public static boolean notAnObstacle(Set<Coordinate>obstacles, Coordinate coordinate){
        return  false;
    }
}
