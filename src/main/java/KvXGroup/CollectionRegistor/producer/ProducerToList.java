package KvXGroup.CollectionRegistor.producer;

import java.util.Date;

public record ProducerToList(Long id, String name, Date openDate) {
    public ProducerToList(Producer p){
        this(p.getId(), p.getName(), p.getOpenDate());
    }
}
