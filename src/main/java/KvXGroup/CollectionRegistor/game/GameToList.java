package KvXGroup.CollectionRegistor.game;

import KvXGroup.CollectionRegistor.console.Console;
import KvXGroup.CollectionRegistor.developer.Developer;
import KvXGroup.CollectionRegistor.producer.Producer;

import java.util.Date;

public record GameToList(Long id, String name, Console console, Developer developer, Date releaseDate, Date buyDate){

}

