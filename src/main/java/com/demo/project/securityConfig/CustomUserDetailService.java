package com.demo.project.securityConfig;

import com.demo.project.entities.Role;
import com.demo.project.entities.User;
import com.demo.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email).orElseThrow(() ->new UsernameNotFoundException("Email not found"));
return  new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRole()));
    }
    private Collection<GrantedAuthority>mapRolesToAuthorities(List<Role> role){
        return role.stream().map(roles->new SimpleGrantedAuthority(roles.getAuthority().toString())).collect(Collectors.toList());

    }
}
