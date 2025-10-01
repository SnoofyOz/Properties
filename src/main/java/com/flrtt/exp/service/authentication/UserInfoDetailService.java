package com.flrtt.exp.service.authentication;

import com.flrtt.exp.repository.database.user.UserEntity; // Import UserEntity
import com.flrtt.exp.repository.database.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(username);
        if(userEntityOptional.isPresent()) {
            return new UserInfoDetails(userEntityOptional.get());
        }
        throw new UsernameNotFoundException(username + " not found");
    }
}
