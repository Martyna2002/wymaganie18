package pl.edu.pwr.abis.service.dto;

import lombok.Data;

@Data
public class EkspertIPMADTO {
    private OsobaDTO osoba;
    private OrganizacjaDTO organizacja;
    private String dziedzina;
}