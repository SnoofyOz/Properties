package com.flrtt.exp.controller.api.portal.models;

import com.flrtt.exp.domain.portal.Portal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PortalModelMapper {
    PortalResponse toModels(Portal portal);
    Portal toDto(PortalRequest request);
}
