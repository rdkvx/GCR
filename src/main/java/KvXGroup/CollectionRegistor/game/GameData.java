package KvXGroup.CollectionRegistor.game;

import java.util.Date;

public record GameData(String name, Long consoleId, Long developerId, Date releaseDate, Date buyDate) {
}
