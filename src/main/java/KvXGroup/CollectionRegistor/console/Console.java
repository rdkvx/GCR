package KvXGroup.CollectionRegistor.console;


import KvXGroup.CollectionRegistor.producer.Producer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Optional;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producerid", nullable = false)
    @Getter
    @Setter
    private Producer producer;


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
}
