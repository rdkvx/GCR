package KvXGroup.CollectionRegistor.console;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Table(name = "console")
@Entity(name = "Console")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @Column(name = "idproducer")
    @NotBlank
    private String idProducer;

    @Column(name = "releasedate")
    @NotNull
    @DateTimeFormat
    private Date releaseDate;

    @Column(name = "buydate")
    @NotNull
    @DateTimeFormat
    private Date buyDate;

    @NotNull
    private Boolean own;
}
