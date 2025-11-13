package com.example.seaprobe.service;

import com.example.seaprobe.dto.Probe;
import com.example.seaprobe.dto.ProbeRequestDTO;

public interface IProbeService {
    Probe operateProbe(ProbeRequestDTO request);
}