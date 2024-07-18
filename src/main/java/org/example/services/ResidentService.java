package org.example.services;

import jakarta.transaction.Transactional;
import org.example.dto.ResidentDTO;

public interface ResidentService {
    ResidentDTO checkAndUpdateSubscription();

}