package KvXGroup.CollectionRegistor.producer;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Table(name = "producer")
@Entity(name = "Producer")
@Getter
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

    public Producer(ProducerData pd){
        this.name = pd.name();
        this.openDate = pd.openDate();
    }
}
