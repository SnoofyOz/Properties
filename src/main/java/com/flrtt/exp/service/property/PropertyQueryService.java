package com.flrtt.exp.service.property;


import com.flrtt.exp.domain.property.Property;
import com.flrtt.exp.domain.property.PropertyId;
import com.flrtt.exp.repository.database.property.PropertyEntity;
import com.flrtt.exp.repository.database.property.PropertyMapper;
import com.flrtt.exp.repository.database.property.PropertyRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PropertyQueryService {
    PropertyRepository propertyRepository;
    PropertyMapper propertyMapper;

    public Property findById(PropertyId propertyId) {
        PropertyEntity entity = propertyRepository.findById(propertyId.id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return propertyMapper.toDTO(entity);
    }
    public List<Property> findAll() {
        List<PropertyEntity> entities = propertyRepository.findAll();
        return entities.stream()
                .map(propertyMapper::toDTO)
                .toList();
    }
}
