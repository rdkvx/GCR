package KvXGroup.CollectionRegistor.console;


import KvXGroup.CollectionRegistor.game.Game;
import KvXGroup.CollectionRegistor.producer.Producer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Table(name = "console")
@Entity(name = "Console")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;


    @Column(name = "releasedate")
    @DateTimeFormat
    private Date releaseDate;

    @Column(name = "buydate")
    @DateTimeFormat
    private Date buyDate;

    @NotNull
    private Boolean own;

    @ManyToOne
    @JoinColumn(name = "producerid", nullable = false)
    @Getter
    @Setter
    private Producer producer;

    @OneToMany(mappedBy = "console")
    private Set<Game> game;


    public Console(ConsoleData cd, Producer prod){
        this.name = cd.name();
        this.releaseDate = cd.releaseDate();
        this.buyDate = cd.buyDate();
        this.own = cd.own();
        this.producer = prod;
    }

    public Console(Optional<Console> c, Producer prod){
        this.id = c.get().getId();
        this.name = c.get().getName();
        this.releaseDate = c.get().getReleaseDate();
        this.buyDate = c.get().getBuyDate();
        this.own = c.get().getOwn();
        this.producer = prod;
    }

    public void updateConsole(ConsoleData cd){
        if(cd.name() != null){
            this.name = cd.name();
        }
        if(cd.releaseDate() != null){
            this.releaseDate = cd.releaseDate();
        }
        if(cd.buyDate() != null){
            this.buyDate = cd.buyDate();
        }
        if(cd.own() != null){
            this.own = cd.own();
        }
        if(cd.producerId() != null){
            this.producer.setId(cd.producerId());
        }
    }

    public Console OptionalToConsole(Optional<Console> console){
        Console c = new Console();
        c.setId(console.get().getId());
        c.setName(console.get().getName());
        c.setReleaseDate(console.get().getReleaseDate());
        c.setBuyDate(console.get().getBuyDate());
        c.setOwn(console.get().getOwn());

        return c;
    }
}
