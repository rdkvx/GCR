package KvXGroup.CollectionRegistor.controller;

import KvXGroup.CollectionRegistor.developer.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developer")
public class Developer {

    @Autowired
    private DeveloperRepository repository;
}
