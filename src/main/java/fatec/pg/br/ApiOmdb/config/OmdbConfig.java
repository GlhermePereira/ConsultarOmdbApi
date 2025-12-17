package fatec.pg.br.ApiOmdb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "omdb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OmdbConfig {
  private String apiKey;
  private String baseUrl;
}
