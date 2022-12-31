package KvXGroup.CollectionRegistor.controller;

import KvXGroup.CollectionRegistor.console.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/console")

public class Console {

    @Autowired
    private ConsoleRepository repository;
}
