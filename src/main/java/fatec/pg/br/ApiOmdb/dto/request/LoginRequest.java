package fatec.pg.br.ApiOmdb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
  private String username;
  private String password;
}
