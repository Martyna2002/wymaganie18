package pl.edu.pwr.abis.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.abis.service.dto.EkspertIPMADTO;
import pl.edu.pwr.abis.service.dto.ResponseDTO;
import pl.edu.pwr.abis.service.impl.EkspertIPMAService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EkspertIPMAResource {

    private final EkspertIPMAService ekspertIPMAService;

    @PostMapping("/importEksperciIPMA")
    public ResponseEntity<ResponseDTO> importEksperci(@RequestBody List<EkspertIPMADTO> dtoList) {
        ResponseDTO response = ekspertIPMAService.importEksperci(dtoList);
        return ResponseEntity.ok(response);
    }
}
