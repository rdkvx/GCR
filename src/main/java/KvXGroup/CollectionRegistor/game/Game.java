package KvXGroup.CollectionRegistor.game;

import KvXGroup.CollectionRegistor.console.Console;
import KvXGroup.CollectionRegistor.console.ConsoleData;
import KvXGroup.CollectionRegistor.developer.Developer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Optional;

@Table(name = "game")
@Entity(name = "Game")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(name = "releasedate")
    @NotNull
    @DateTimeFormat
    private Date releaseDate;

    @Column(name = "buydate")
    @DateTimeFormat
    private Date buyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consoleid", nullable = false)
    @Getter
    @Setter
    private Console console;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developerid", nullable = false)
    @Getter
    @Setter
    private Developer developer;

    public Game(GameData request, Console console, Developer developer){
        this.name = request.name();
        this.console = console;
        this.developer = developer;
        this.releaseDate = request.releaseDate();
        this.buyDate = request.buyDate();
    }

    public Game(Optional<Game> game, Console console, Developer developer){
        this.id = game.get().getId();
        this.name = game.get().getName();
        this.console = console;
        this.developer = developer;
        this.releaseDate = game.get().getReleaseDate();
        this.buyDate = game.get().getBuyDate();
    }

    public void updateGame(GameData gd){
        if(gd.name() != ""){
            this.name = gd.name();
        }
        if(gd.consoleId() != null){
            this.console.setId(gd.consoleId()); ;
        }
        if(gd.developerId() != null){
            this.developer.setId(gd.developerId()); ;
        }
        if(gd.releaseDate() != null){
            this.releaseDate = gd.releaseDate();
        }
        if(gd.releaseDate() != null){
            this.buyDate = gd.buyDate();
        }
    }
}
