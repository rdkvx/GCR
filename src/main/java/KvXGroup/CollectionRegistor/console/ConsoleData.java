package KvXGroup.CollectionRegistor.console;

import KvXGroup.CollectionRegistor.producer.Producer;

import java.util.Date;

/*public record ConsoleData(String name, Producer producer, Date releaseDate, Date buyDate, Boolean own){
}*/

public record ConsoleData(String name, Long producerId, Date releaseDate, Date buyDate, Boolean own){
}
