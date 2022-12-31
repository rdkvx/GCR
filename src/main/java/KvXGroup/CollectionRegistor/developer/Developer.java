package KvXGroup.CollectionRegistor.developer;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "developer")
@Entity(name = "Developer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

}
