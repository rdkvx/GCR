package KvXGroup.CollectionRegistor.developer;

import KvXGroup.CollectionRegistor.game.Game;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Optional;
import java.util.Set;

@Table(name = "developer")
@Entity(name = "Developer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "developer")
    private Set<Game> game;

    public Developer(DeveloperData dd){
        this.name = dd.name();
    }

    public void updateDeveloper(DeveloperData dd){
        if(dd.name() != null){
            this.name = dd.name();
        }
    }

    public Developer OptionalToDeveloper(Optional<Developer> developer){
        Developer dev = new Developer();
        dev.setId(developer.get().getId());
        dev.setName(developer.get().getName());
        dev.setGame(developer.get().getGame());

        return dev;
    }

}
