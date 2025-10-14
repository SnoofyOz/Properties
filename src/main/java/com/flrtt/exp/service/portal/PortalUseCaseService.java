package com.flrtt.exp.service.portal;


import com.flrtt.exp.domain.portal.Portal;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PortalUseCaseService {
    PortalQueryService portalQueryService;

    public List<Portal> findAll(String code) {
        return portalQueryService.findAll();
    }
}
