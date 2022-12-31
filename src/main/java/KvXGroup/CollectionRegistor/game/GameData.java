package KvXGroup.CollectionRegistor.game;

import java.util.Date;

public record GameData(String name, Long idConsole, Long idDeveloper, Date releaseDate, Date buyDate) {
}
