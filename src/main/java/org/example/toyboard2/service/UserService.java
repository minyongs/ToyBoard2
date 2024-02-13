package org.example.toyboard2.service;



import org.example.toyboard2.dto.SiteUserDTO;
import org.example.toyboard2.entity.SiteUser;
import org.example.toyboard2.exception.DataNotFoundException;
import org.example.toyboard2.repository.SiteUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final SiteUserRepository siteUserRepository;
    private final PasswordEncoder passwordEncoder;



    public void create(SiteUserDTO siteUserDTO) {
        SiteUser user = new SiteUser();
        user.setUsername(siteUserDTO.getUserName());
        user.setEmail(siteUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(siteUserDTO.getPassword()));
        siteUserRepository.save(user);

    }

    public SiteUser getUser(String username){
        Optional<SiteUser> siteUser = siteUserRepository.findByUsername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("사용자를 찾을 수 없습니다");
        }
    }

    }

