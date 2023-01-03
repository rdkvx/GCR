package KvXGroup.CollectionRegistor.controller;

import KvXGroup.CollectionRegistor.console.Console;
import KvXGroup.CollectionRegistor.console.ConsoleRepository;
import KvXGroup.CollectionRegistor.developer.Developer;
import KvXGroup.CollectionRegistor.developer.DeveloperRepository;
import KvXGroup.CollectionRegistor.game.GameData;
import KvXGroup.CollectionRegistor.game.GameRepository;
import KvXGroup.CollectionRegistor.game.GameToList;
import com.electronwill.nightconfig.core.conversion.Path;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class Game {

    @Autowired
    private GameRepository GameRepo;
    @Autowired
    private DeveloperRepository DeveloperRepo;
    @Autowired
    private ConsoleRepository ConsoleRepo;

    @GetMapping
    public List<GameToList> getGames(){
        return GameRepo.getAll();
    }

    @GetMapping("/{id}")
    public KvXGroup.CollectionRegistor.game.Game getGameByID(@PathVariable Long id){
        var gameRaw = GameRepo.findById(id);
        var consoleRaw = ConsoleRepo.findById(gameRaw.get().getConsole().getId());
        var developerRaw = DeveloperRepo.findById(gameRaw.get().getDeveloper().getId());

        Console c = new Console();
        var console = c.OptionalToConsole(consoleRaw);

        Developer d = new Developer();
        var developer = d.OptionalToDeveloper(developerRaw);

        KvXGroup.CollectionRegistor.game.Game g = new KvXGroup.CollectionRegistor.game.Game(gameRaw, console, developer);

        return g;
    }

    @PostMapping
    @Transactional
    public String createGame(@RequestBody GameData request){
        var consoleRaw = ConsoleRepo.findById(request.consoleId());
        Console c = new Console();
        var console = c.OptionalToConsole(consoleRaw);

        var developerRaw = DeveloperRepo.findById(request.developerId());
        Developer d = new Developer();
        var developer = d.OptionalToDeveloper(developerRaw);

        KvXGroup.CollectionRegistor.game.Game game = new KvXGroup.CollectionRegistor.game.Game(request, console, developer);

        GameRepo.save(game);

        return request.name()+" registered successfully";
    }

    @PutMapping("/{id}")
    @Transactional
    public String updateGame(@PathVariable Long id, @RequestBody GameData request){
        var game = GameRepo.getReferenceById(id);
        game.updateGame(request);

        var response = game.getName()+" updated successfully";
        return response;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deleteGame(@PathVariable Long id){
        GameRepo.deleteById(id);

        var response = "game deleted successfully";

        return response;
    }

}
