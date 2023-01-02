package KvXGroup.CollectionRegistor.console;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsoleRepository extends JpaRepository<Console, Long> {

    @Query("SELECT new KvXGroup.CollectionRegistor.console.ConsoleToList(c.id, c.name, c.producer, c.releaseDate, c.buyDate, c.own) FROM Console c")
    public List<ConsoleToList> getAll();
}
