package com.example.seaprobe.util;

import com.example.seaprobe.dto.Coordinate;
import com.example.seaprobe.dto.Grid;
import java.util.Set;

public class Validator {
    public static  boolean validateCoordinates(Grid grid, Coordinate coordinate) {
        return coordinate.x()>grid.x1() && coordinate.x()<=grid.x2() &&
                coordinate.y()> grid.y1() && coordinate.y()<=grid.y2();
    }
    public static boolean notAnObstacle(Set<Coordinate>obstacles, Coordinate coordinate){
        return  !obstacles.contains(coordinate);
    }
}
