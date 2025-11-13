package com.example.seaprobe.service;

import com.example.seaprobe.commands.CommandFactory;
import com.example.seaprobe.dto.Grid;
import com.example.seaprobe.dto.Probe;
import com.example.seaprobe.dto.ProbeRequestDTO;
import com.example.seaprobe.exception.ProbeValidationException;
import com.example.seaprobe.util.Validator;
import org.springframework.stereotype.Service;

@Service
public class ProbeServiceImpl implements IProbeService {

    private CommandFactory commandFactory;

    public ProbeServiceImpl(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public Probe operateProbe(ProbeRequestDTO request) {
        Grid grid = new Grid(
                request.getStartX(),
                request.getStartX() + request.getWidthX(),
                request.getStartY(),
                request.getStartY() + request.getHeightY()
        );

        if (!Validator.validateCoordinates(grid, request.getProbe().getCurrentCoordinate())) {
            throw new ProbeValidationException("Invalid Request, Probe cannot be outside of the grid");
        }
        // Add current coordinate to navigation history
        request.getProbe().getNavigationHistory().add(request.getProbe().getCurrentCoordinate());

        return request.getProbe();
    }
}
