package com.flrtt.exp.repository.database.property;


import com.flrtt.exp.dto.property.Property;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PropertyMapper {
    @Mapping(target = "propertyId", source = "propertyId")
    Property toDTO(PropertyEntity propertyEntity);
    PropertyEntity toEntity(Property propertyDTO);
}
