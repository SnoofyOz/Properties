package com.flrtt.exp.controller.api.property;

import com.flrtt.exp.dto.property.Property;
import com.flrtt.exp.dto.property.PropertyId;
import com.flrtt.exp.service.property.PropertyUseCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class PropertyController implements PropertyInterface{
    private final PropertyUseCaseService propertyUseCaseService;
    @Override
    public Property findById(String id) {
        return propertyUseCaseService.findById(new PropertyId(id));
    }
}
