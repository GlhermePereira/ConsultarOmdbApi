package fatec.pg.br.ApiOmdb.controller;

import fatec.pg.br.ApiOmdb.model.OmdbResponse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import fatec.pg.br.ApiOmdb.service.HistoryService;
import fatec.pg.br.ApiOmdb.service.OmdbService;
import fatec.pg.br.ApiOmdb.model.User;
import lombok.RequiredArgsConstructor;
import fatec.pg.br.ApiOmdb.dto.response.SearchResponse;
import fatec.pg.br.ApiOmdb.dto.response.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SearchController {
  @Autowired
  private OmdbService omdbService;
  @Autowired
  private HistoryService historyservice;

  //adicionar o tipo como parametro tbm
  @GetMapping
  public Map<String, Object> search(
      @RequestParam String title,
      @RequestParam(defaultValue = "1") int page,
      @RequestParam String type,
      @AuthenticationPrincipal User user) {

    Map<String, Object> response = omdbService.searchByTitle(title, page, type);

    if (user != null) {
      historyservice.saveSearch(user, title);
    }
    return response;
  }
}
