package com.flrtt.exp.controller.api.property;


import com.flrtt.exp.domain.property.Property;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/api/properties")
public interface PropertyInterface {

    @GetMapping("/{id}")
    Property findById(@PathVariable String id);
}
