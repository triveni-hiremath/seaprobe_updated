package com.example.seaprobe.dto;

import com.example.seaprobe.enums.DirectionEnum;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Probe {

    private Coordinate currentCoordinate;

    private DirectionEnum currentDirection;

    private List<Coordinate> navigationHistory = new ArrayList<>();

}