package com.flrtt.exp.controller.api.property.models;

import com.flrtt.exp.dto.property.Property;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PropertyModelMapper {
    @Mapping(target = "propertyId", source = "propertyId")
    PropertyResponse toModels(Property property);
    Property toDto(PropertyRequest request);
}
