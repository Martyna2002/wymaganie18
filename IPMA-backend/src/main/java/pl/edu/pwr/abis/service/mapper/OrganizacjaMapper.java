package pl.edu.pwr.abis.service.mapper;

import org.mapstruct.Mapper;
import pl.edu.pwr.abis.domain.entities.Organizacja;
import pl.edu.pwr.abis.service.dto.OrganizacjaDTO;

@Mapper(componentModel = "spring")
public interface OrganizacjaMapper {
    Organizacja toEntity(OrganizacjaDTO dto);
    OrganizacjaDTO toDto(Organizacja entity);
}
