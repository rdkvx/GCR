package KvXGroup.CollectionRegistor.producer;

import KvXGroup.CollectionRegistor.console.Console;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Table(name = "producer")
@Entity(name = "Producer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @DateTimeFormat
    @Column(name = "opendate")
    private Date openDate;

    @OneToMany(mappedBy = "producer")
    private Set<Console> consoles;

    public Producer(ProducerData pd){
        this.name = pd.name();
        this.openDate = pd.openDate();
    }

    public void updateProducer(ProducerData pd){
        if (pd.name() != "" || pd.name() != null){
            this.name = pd.name();
        }
        if (pd.openDate() != null){
            this.openDate = pd.openDate();
        }
    }

    public Producer OptionalToProducer(Optional<Producer> producer){
        Producer prod = new Producer();
        prod.setId(producer.get().getId());
        prod.setName(producer.get().getName());
        prod.setOpenDate(producer.get().getOpenDate());
        prod.setConsoles(producer.get().getConsoles());

        return prod;
    }
}
