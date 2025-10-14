package com.flrtt.exp.repository.database.portal;


import com.flrtt.exp.domain.portal.Portal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PortalMapper {
    @Mapping(target = "portalId", source = "portalId")
    Portal toDTO(PortalEntity portalEntity);
    PortalEntity toEntity(Portal portalDTO);
}
