package pl.edu.pwr.abis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwr.abis.domain.entities.Organizacja;
import pl.edu.pwr.abis.domain.entities.users.EkspertIPMA;
import pl.edu.pwr.abis.domain.entities.users.Osoba;
import pl.edu.pwr.abis.repository.EkspertIPMARepository;
import pl.edu.pwr.abis.repository.OrganizacjaRepository;
import pl.edu.pwr.abis.repository.OsobaRepository;
import pl.edu.pwr.abis.service.dto.EkspertIPMADTO;
import pl.edu.pwr.abis.service.dto.ResponseDTO;
import pl.edu.pwr.abis.service.dto.StatusResponse;
import pl.edu.pwr.abis.service.mapper.EkspertIPMAMapper;
import pl.edu.pwr.abis.service.mapper.OrganizacjaMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EkspertIPMAService {

    private final EkspertIPMARepository ekspertRepo;
    private final OsobaRepository osobaRepo;
    private final OrganizacjaRepository organizacjaRepo;
    private final EkspertIPMAMapper mapper;
    private final OrganizacjaMapper organizacjaMapper;

    @Transactional
    public ResponseDTO importEksperci(List<EkspertIPMADTO> lista) {
        int dodane = 0;
        int zmodyfikowane = 0;

        for (EkspertIPMADTO dto : lista) {
            String email = dto.getOsoba().getEmail();
            Optional<Osoba> istniejącaOsoba = osobaRepo.findByEmail(email);

            Osoba osoba;
            if (istniejącaOsoba.isPresent()) {
                // aktualizacja istniejącej osoby
                osoba = istniejącaOsoba.get();
                osoba.setImie(dto.getOsoba().getImie());
                osoba.setNazwisko(dto.getOsoba().getNazwisko());
                osoba.setTelefon(dto.getOsoba().getTelefon());
                osobaRepo.save(osoba);
                zmodyfikowane++;
            } else {
                // tworzenie nowego eksperta jako osoby
                EkspertIPMA nowyEkspert = new EkspertIPMA();
                nowyEkspert.setImie(dto.getOsoba().getImie());
                nowyEkspert.setNazwisko(dto.getOsoba().getNazwisko());
                nowyEkspert.setEmail(dto.getOsoba().getEmail());
                nowyEkspert.setTelefon(dto.getOsoba().getTelefon());
                osobaRepo.save(nowyEkspert);
                osoba = nowyEkspert;
                dodane++;
            }

            EkspertIPMA ekspert = ekspertRepo.findByEmail(email).orElse(new EkspertIPMA());
            ekspert.setImie(osoba.getImie());
            ekspert.setNazwisko(osoba.getNazwisko());
            ekspert.setEmail(osoba.getEmail());
            ekspert.setTelefon(osoba.getTelefon());
            ekspert.setDziedzina(dto.getDziedzina());
            ekspert.setOrganizacja(findOrCreateOrganizacja(dto));

            ekspertRepo.save(ekspert);
        }

        ResponseDTO response = new ResponseDTO();
        response.setKodStatusu(StatusResponse.OK);
        response.setLiczbaNowychEkspertów(dodane);
        response.setLiczbaZmienionychEkspertów(zmodyfikowane);
        return response;
    }

    private Organizacja findOrCreateOrganizacja(EkspertIPMADTO dto) {
        return organizacjaRepo.findByEmail(dto.getOrganizacja().getEmail())
            .orElseGet(() -> {
                Organizacja nowa = organizacjaMapper.toEntity(dto.getOrganizacja());
                return organizacjaRepo.save(nowa);
            });
    }
}
