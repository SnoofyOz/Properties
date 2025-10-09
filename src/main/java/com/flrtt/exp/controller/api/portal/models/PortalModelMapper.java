package com.flrtt.exp.controller.api.portal.models;

import com.flrtt.exp.dto.portal.Portal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PortalModelMapper {
    PortalResponse toModels(Portal portal);
    Portal toDto(PortalRequest request);
}
