package pl.edu.pwr.abis.service.mapper;

import org.mapstruct.Mapper;


import pl.edu.pwr.abis.service.dto.OrganizacjaDTO;
import pl.edu.pwr.abis.service.dto.OsobaDTO;
import pl.edu.pwr.abis.domain.entities.Organizacja;
import pl.edu.pwr.abis.domain.entities.users.Osoba;

@Mapper(componentModel = "spring", uses = {OrganizacjaMapper.class})
public interface EkspertIPMAMapper {


    //Osoba toOsoba(OsobaDTO dto);

    Organizacja toOrganizacja(OrganizacjaDTO dto);

    
}
