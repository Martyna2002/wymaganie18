package pl.edu.pwr.abis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pwr.abis.domain.entities.users.EkspertIPMA;

import java.util.Optional;

public interface EkspertIPMARepository extends JpaRepository<EkspertIPMA, Long> {
    Optional<EkspertIPMA> findByEmail(String email);
}
