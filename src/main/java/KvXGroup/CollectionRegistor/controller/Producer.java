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
    public ProducerRepository ProducerRepo;

    @GetMapping
    public Page<ProducerToList> getProducers(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        return ProducerRepo.findAll(pagination).map(ProducerToList::new);

    }

    @GetMapping("/{id}")
    public Optional<KvXGroup.CollectionRegistor.producer.Producer> getProducersByID(@PathVariable Long id){
       return ProducerRepo.findById(id);
    }

    @PostMapping
    @Transactional
    public String createProducer(@RequestBody ProducerData request){
        ProducerRepo.save(new KvXGroup.CollectionRegistor.producer.Producer(request));
        return request.name()+" producer registered successfully";
    }

    @PutMapping("/{id}")
    @Transactional
    public String updateProducer(@RequestBody ProducerData request, @PathVariable Long id){
        var producer = ProducerRepo.getReferenceById(id);
        producer.updateProducer(request);

        return request.name()+" producer updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteProducer(@PathVariable Long id){
        ProducerRepo.deleteById(id);

        return "producer deleted successfully";
    }
}
