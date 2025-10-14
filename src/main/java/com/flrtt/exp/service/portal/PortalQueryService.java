package com.flrtt.exp.service.portal;


import com.flrtt.exp.domain.portal.Portal;
import com.flrtt.exp.repository.database.portal.PortalEntity;
import com.flrtt.exp.repository.database.portal.PortalMapper;
import com.flrtt.exp.repository.database.portal.PortalRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PortalQueryService {
    PortalRepository portalRepository;
    PortalMapper portalMapper;

    public List<Portal> findAll() {
        List<PortalEntity> entities = portalRepository.findAll();
        return entities.stream()
                .map(portalMapper::toDTO)
                .toList();
    }
}
