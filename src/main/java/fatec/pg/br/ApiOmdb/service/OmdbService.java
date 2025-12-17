package fatec.pg.br.ApiOmdb.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import fatec.pg.br.ApiOmdb.config.OmdbConfig;
import fatec.pg.br.ApiOmdb.model.OmdbResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OmdbService {
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private OmdbConfig config;

  public Map<String, Object> searchByTitle(String title, int page) {
    String url = String.format(
        "%s?s=%s&page=%d&apikey=%s",
        config.getBaseUrl(),
        title,
        page,
        config.getApiKey());

    return restTemplate.getForObject(url, Map.class);

  }

}
