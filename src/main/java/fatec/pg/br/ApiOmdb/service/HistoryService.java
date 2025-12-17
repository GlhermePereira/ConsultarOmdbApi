package fatec.pg.br.ApiOmdb.service;

import fatec.pg.br.ApiOmdb.model.SearchHistory;
import fatec.pg.br.ApiOmdb.model.User;
import fatec.pg.br.ApiOmdb.repository.SearchHistoryRepository;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
  @Autowired
  private SearchHistoryRepository historyRepository;

  // save history seach
  public void saveSearch(User user, String query) {
    SearchHistory history = new SearchHistory();
    history.setUser(user);
    history.setQuery(query);
    history.setSearchedAt(LocalDateTime.now());
    historyRepository.save(history);

  }

  public List<SearchHistory> getUserHistory(User user) {
    return historyRepository.findByUserOrderBySearchedAtDesc(user);
  }
}
