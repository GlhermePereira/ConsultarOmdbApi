package fatec.pg.br.ApiOmdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OmdbResponse {
  private String title;
  private String year;
  private String type;
  private String poster;
}
