package pl.edu.pwr.abis.service.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private StatusResponse kodStatusu;
    private String error;
    private int liczbaNowychEkspertów;
    private int liczbaZmienionychEkspertów;
}
