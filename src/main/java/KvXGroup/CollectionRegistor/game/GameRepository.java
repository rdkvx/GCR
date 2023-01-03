package KvXGroup.CollectionRegistor.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query("SELECT new KvXGroup.CollectionRegistor.game.GameToList(g.id, g.name, g.console, g.developer, g.releaseDate, g.buyDate) FROM Game g")
    public List<GameToList> getAll();
}
