package com.example.seaprobe.service;

import com.example.seaprobe.commands.CommandFactory;
import com.example.seaprobe.dto.Coordinate;
import com.example.seaprobe.dto.Probe;
import com.example.seaprobe.dto.ProbeRequestDTO;
import com.example.seaprobe.exception.ProbeValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProbeServiceImplTest {

    private CommandFactory commandFactory;
    private ProbeServiceImpl probeService;

    @BeforeEach
    void setup() {
        commandFactory = mock(CommandFactory.class);
        probeService = new ProbeServiceImpl(commandFactory);
    }
    //Red
    @Test
    void operateProbe_shouldThrowException_WhenProbeOutsideGrid() {
        Probe probe = Probe.builder()
                .currentCoordinate(new Coordinate(10, 10)) // outside grid
                .navigationHistory(new ArrayList<>())
                .build();

        ProbeRequestDTO request = ProbeRequestDTO.builder()
                .startX(0)
                .startY(0)
                .widthX(5)
                .heightY(5)
                .probe(probe)
                .obstacles(new HashSet<>())
                .commands(Collections.emptyList())
                .build();

        ProbeValidationException ex = assertThrows(ProbeValidationException.class,
                () -> probeService.operateProbe(request));

        assertEquals("Invalid Request, Probe cannot be outside of the grid", ex.getMessage());
    }
    //yellow
    @Test
    void operateProbe_shouldSucceed_WhenProbeAtGridBoundary() {
        Probe probe = Probe.builder()
                .currentCoordinate(new Coordinate(5, 5)) // on grid boundary
                .navigationHistory(new ArrayList<>())
                .build();

        ProbeRequestDTO request = ProbeRequestDTO.builder()
                .startX(0)
                .startY(0)
                .widthX(5)
                .heightY(5)
                .probe(probe)
                .obstacles(new HashSet<>())
                .commands(Collections.emptyList())
                .build();

        Probe result = probeService.operateProbe(request);

        assertNotNull(result);
        assertEquals(probe.getCurrentCoordinate(), result.getCurrentCoordinate());
        assertEquals(1, result.getNavigationHistory().size()); // history updated
    }
}
