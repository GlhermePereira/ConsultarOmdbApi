package fatec.pg.br.ApiOmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fatec.pg.br.ApiOmdb.model.User;
import fatec.pg.br.ApiOmdb.model.SearchHistory;
import java.util.List;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
  List<SearchHistory> findByUserOrderBySearchedAtDesc(User user);
}
