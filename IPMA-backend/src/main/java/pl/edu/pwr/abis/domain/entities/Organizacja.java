package pl.edu.pwr.abis.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Organizacja {

    @Id
    private String nip;

    private String nazwa;
    private String email;
}
