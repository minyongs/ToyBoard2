package org.example.toyboard2.service;



import org.example.toyboard2.dto.SiteUserDTO;
import org.example.toyboard2.entity.SiteUser;
import org.example.toyboard2.repository.SiteUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final SiteUserRepository SiteuserRepository;
    private final PasswordEncoder passwordEncoder;


    public void create(SiteUserDTO siteUserDTO) {
        SiteUser user = new SiteUser();
        user.setUsername(siteUserDTO.getUserName());
        user.setEmail(siteUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(siteUserDTO.getPassword()));
        SiteuserRepository.save(user);

    }
}
