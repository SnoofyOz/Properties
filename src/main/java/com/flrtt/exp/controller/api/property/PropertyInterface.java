package com.flrtt.exp.controller.api.property;


import com.flrtt.exp.dto.property.Property;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static com.flrtt.exp.bootstrap.constants.PathConstants.API_PROPERTIES;

@RequestMapping(API_PROPERTIES)
public interface PropertyInterface {

    @GetMapping("/{id}")
    Property findById(@PathVariable String id);
}
