package com.baedal.owner.application.service;

import com.baedal.owner.adapter.out.persistence.entity.OwnerEntity;
import com.baedal.owner.adapter.out.persistence.manager.OwnerEntityReader;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

  private final OwnerEntityReader reader;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    OwnerEntity owner = reader.findByEmail(username);
    return new UserDetailsImpl(owner);
  }

  public record UserDetailsImpl(OwnerEntity owner) implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of();
    }

    @Override
    public String getPassword() {
      return owner.getPassword();
    }

    @Override
    public String getUsername() {
      return owner.getEmail();
    }
  }
}
