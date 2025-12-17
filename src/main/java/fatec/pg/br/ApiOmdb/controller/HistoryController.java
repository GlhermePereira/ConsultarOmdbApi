package fatec.pg.br.ApiOmdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fatec.pg.br.ApiOmdb.service.HistoryService;
import fatec.pg.br.ApiOmdb.service.OmdbService;
import fatec.pg.br.ApiOmdb.dto.response.SearchHistoryResponse;
import fatec.pg.br.ApiOmdb.model.User;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {
  @Autowired
  private HistoryService historyService;
  @Autowired OmdbService omdbService;

  @GetMapping
  public List<SearchHistoryResponse> getHistory(@AuthenticationPrincipal User user) {
    return historyService.getUserHistory(user)
        .stream()
        .map(h -> new SearchHistoryResponse(
            h.getQuery(),
            h.getSearchedAt()))
        .toList();
  }

  @GetMapping("/details/{imdbId}")
  public Map<String, Object> details(@PathVariable String imdbId) {
    return omdbService.getDetailsById(imdbId);
  }
}
