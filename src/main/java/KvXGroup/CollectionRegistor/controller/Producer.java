package KvXGroup.CollectionRegistor.controller;

import KvXGroup.CollectionRegistor.producer.ProducerData;
import KvXGroup.CollectionRegistor.producer.ProducerRepository;
import KvXGroup.CollectionRegistor.producer.ProducerToList;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/producer")
public class Producer {

    @Autowired
    private ProducerRepository repository;

    @GetMapping
    public Page<ProducerToList> getProducers(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        var obj = repository.findAll(pagination).map(ProducerToList::new);
        return obj;
    }

    @GetMapping("/{id}")
    public Optional<KvXGroup.CollectionRegistor.producer.Producer> getProducersByID(@PathVariable Long id){
       return repository.findById(id);
    }

    @PostMapping
    @Transactional
    public void createProducer(@RequestBody ProducerData request){
        repository.save(new KvXGroup.CollectionRegistor.producer.Producer(request));
    }
}
