package com.flrtt.exp.service.property;


import com.flrtt.exp.domain.property.Property;
import com.flrtt.exp.domain.property.PropertyId;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PropertyUseCaseService {
    PropertyQueryService propertyQueryService;
    PropertyCommandService propertyCommandService;

    public List<Property> findAll(String code) {
        return propertyQueryService.findAll();
    }
    public Property findById(PropertyId id) {
        return propertyQueryService.findById(id);
    }
}
