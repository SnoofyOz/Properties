package com.flrtt.exp.controller.api.admin;

import com.flrtt.exp.controller.api.portal.models.PortalModelMapper;
import com.flrtt.exp.controller.api.portal.models.PortalResponse;
import com.flrtt.exp.controller.api.property.models.PropertyModelMapper;
import com.flrtt.exp.controller.api.property.models.PropertyResponse;
import com.flrtt.exp.controller.api.user.models.UserModelMapper;
import com.flrtt.exp.controller.api.user.models.UserRequest;
import com.flrtt.exp.controller.api.user.models.UserResponse;
import com.flrtt.exp.dto.portal.Portal;
import com.flrtt.exp.dto.property.Property;
import com.flrtt.exp.dto.user.User;
import com.flrtt.exp.dto.user.UserId;
import com.flrtt.exp.service.portal.PortalUseCaseService;
import com.flrtt.exp.service.property.PropertyUseCaseService;
import com.flrtt.exp.service.user.UserUseCaseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdminController implements AdminInterface {
    UserUseCaseService userUseCaseService;
    UserModelMapper userModelMapper;
    PropertyUseCaseService propertyUseCaseService;
    PropertyModelMapper propertyModelMapper;
    PortalUseCaseService portalUseCaseService;
    PortalModelMapper portalModelMapper;


    @Override
    public List<UserResponse> findAllUser(String code) {
        List<User> users = userUseCaseService.findAll(code);
        return users.stream()
                .map(userModelMapper::toModels)
                .toList();
    }

    @Override
    public User findById(String id) {
        return userUseCaseService.findById(new UserId(id));
    }

    @Override
    public void update(String id, UserRequest request) {
        User req = userModelMapper.toDto(request);
        userUseCaseService.updateUser(id, req);
    }

    @Override
    public void delete(String id) {
        userUseCaseService.deleteUser(id);
    }

    @Override
    public List<PropertyResponse> findAllProperties(String code) {
        List<Property> properties = propertyUseCaseService.findAll(code);
        return properties.stream()
                .map(propertyModelMapper::toModels)
                .toList();
    }

    @Override
    public List<PortalResponse> findAllPortal(String code) {
        List<Portal> portals = portalUseCaseService.findAll(code);
        return portals.stream()
                .map(portalModelMapper::toModels)
                .toList();
    }

}
