package fatec.pg.br.ApiOmdb.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import fatec.pg.br.ApiOmdb.model.User;
import fatec.pg.br.ApiOmdb.repository.SearchHistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fatec.pg.br.ApiOmdb.dto.response.LoginResponse;
import fatec.pg.br.ApiOmdb.dto.response.UserResponse;
import fatec.pg.br.ApiOmdb.repository.UserRepository;
import fatec.pg.br.ApiOmdb.dto.request.LoginRequest;
import fatec.pg.br.ApiOmdb.dto.request.RegisterUserRequest;
import jakarta.persistence.*;

@Service
@RequiredArgsConstructor
public class UserService {
  @Autowired
  private UserRepository userRepository;
  private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public UserResponse register(RegisterUserRequest request) {
    User user = new User();

    if (userRepository.existsByUsername(request.getUsername())) {
      throw new RuntimeException("name already exists");
    }

    user.setUsername(request.getUsername());
    user.setPassword(passwordEncoder.encode(request.getPassword()));

    User savedUser = userRepository.save(user);

      return new UserResponse(savedUser.getId(), savedUser.getUsername());
  }

  public LoginResponse login(LoginRequest request) {
    User user = userRepository.findByUsername(request.getUsername())
        .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new RuntimeException("incorrect password");
    }

    return new LoginResponse(user.getId(), user.getUsername(),null);
  }
}
