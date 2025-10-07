package com.flrtt.exp.service.portal;


import com.flrtt.exp.dto.portal.Portal;
import com.flrtt.exp.dto.property.Property;
import com.flrtt.exp.dto.property.PropertyId;
import com.flrtt.exp.repository.database.portal.PortalEntity;
import com.flrtt.exp.repository.database.portal.PortalMapper;
import com.flrtt.exp.repository.database.portal.PortalRepository;
import com.flrtt.exp.repository.database.property.PropertyEntity;
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
