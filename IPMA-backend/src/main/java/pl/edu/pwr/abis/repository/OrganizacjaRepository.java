package pl.edu.pwr.abis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.abis.domain.entities.Organizacja;

import java.util.Optional;

public interface OrganizacjaRepository extends JpaRepository<Organizacja, String> {
    Optional<Organizacja> findByEmail(String email);
}
