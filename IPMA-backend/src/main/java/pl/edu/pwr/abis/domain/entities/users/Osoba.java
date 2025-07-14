package pl.edu.pwr.abis.domain.entities.users;

import lombok.Getter;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "osoba")
public abstract class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String imie;
    private String nazwisko;
    private String email;
    private String telefon;
}
