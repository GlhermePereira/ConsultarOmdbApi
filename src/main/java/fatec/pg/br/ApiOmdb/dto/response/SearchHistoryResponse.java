package fatec.pg.br.ApiOmdb.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchHistoryResponse {
  private String query;
  private LocalDateTime searchAt;

}
