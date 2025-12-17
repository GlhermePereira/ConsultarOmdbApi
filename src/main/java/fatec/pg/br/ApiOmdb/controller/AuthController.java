package fatec.pg.br.ApiOmdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fatec.pg.br.ApiOmdb.service.UserService;
import fatec.pg.br.ApiOmdb.dto.response.UserResponse;
import fatec.pg.br.ApiOmdb.dto.request.RegisterUserRequest;
import fatec.pg.br.ApiOmdb.dto.request.LoginRequest;
import fatec.pg.br.ApiOmdb.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<UserResponse> register(@RequestBody RegisterUserRequest request) {
    return ResponseEntity.ok(userService.register(request));
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(userService.login(request));
  }
}
