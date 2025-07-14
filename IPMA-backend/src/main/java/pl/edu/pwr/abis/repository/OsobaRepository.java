package pl.edu.pwr.abis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.abis.domain.entities.users.Osoba;

import java.util.Optional;

public interface OsobaRepository extends JpaRepository<Osoba, Long> {
    Optional<Osoba> findByEmail(String email);
}
