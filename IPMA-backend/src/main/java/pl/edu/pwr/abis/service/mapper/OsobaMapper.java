package pl.edu.pwr.abis.service.mapper;

import org.mapstruct.Mapper;
import pl.edu.pwr.abis.domain.entities.users.Osoba;
import pl.edu.pwr.abis.service.dto.OsobaDTO;

@Mapper(componentModel = "spring")
public interface OsobaMapper {
    //Osoba toEntity(OsobaDTO dto);
}
