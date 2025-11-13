package com.example.seaprobe.dto;

import com.example.seaprobe.enums.CommandEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class ProbeRequestDTO {

    private int startX;
    private int startY;
    private int widthX;
    private int heightY;

    private Probe probe;
    private Set<Coordinate> obstacles;
    private List<CommandEnum> commands;
}
