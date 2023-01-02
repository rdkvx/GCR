package KvXGroup.CollectionRegistor.console;

import KvXGroup.CollectionRegistor.producer.Producer;

import java.util.Date;

public record ConsoleToList(Long id, String name, Producer producer, Date releaseDate, Date buyDate, boolean own) {
    public ConsoleToList(Console c){
        this(c.getId(), c.getName(), c.getProducer(), c.getReleaseDate(), c.getBuyDate(), c.getOwn());
    }
}
