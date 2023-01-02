package KvXGroup.CollectionRegistor.controller;

import KvXGroup.CollectionRegistor.game.GameData;
import KvXGroup.CollectionRegistor.game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class Game {

    @Autowired
    private GameRepository GameRepo;

    @GetMapping
    public String olaMundo(){
        return "hello world";
    }

    @PostMapping
    public void postGaming(@RequestBody GameData date){

    }

}
