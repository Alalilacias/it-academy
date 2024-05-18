package com.api.fortuna.model.service.interfaces;

import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;

public interface PlayerService {
    PlayerDTO create(ClientAuthRequest request);
}
