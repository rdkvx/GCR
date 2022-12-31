package KvXGroup.CollectionRegistor.game;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Table(name = "game")
@Entity(name = "Game")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(name = "idconsole")
    @NotNull
    private Long idConsole;

    @Column(name = "iddeveloper")
    @NotNull
    private Long idDeveloper;

    @Column(name = "releasedate")
    @NotNull
    @DateTimeFormat
    private Date releaseDate;

    @Column(name = "buydate")
    @NotNull
    @DateTimeFormat
    private Date buyDate;

}
