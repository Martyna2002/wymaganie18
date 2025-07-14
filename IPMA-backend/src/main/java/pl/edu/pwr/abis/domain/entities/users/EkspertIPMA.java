package pl.edu.pwr.abis.domain.entities.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pwr.abis.domain.entities.Organizacja;

@Getter
@Setter
@Entity
@Table(name = "ekspertipma")
public class EkspertIPMA extends Osoba {

    
    
    private Long id;

    private String dziedzina;

    @ManyToOne(optional = false)
    private Organizacja organizacja;
}
