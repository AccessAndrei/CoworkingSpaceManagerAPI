package org.example.services;

import org.example.dto.ResidentDTO;

public interface ResidentService {
    ResidentDTO checkAndUpdateSubscription(int residentId);
}