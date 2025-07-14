package pl.edu.pwr.abis.web.rest;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import pl.edu.pwr.abis.service.impl.EkspertIPMAService;
import pl.edu.pwr.abis.service.dto.ResponseDTO;
import pl.edu.pwr.abis.service.dto.EkspertIPMADTO;

import java.util.List;




@RestController
@RequestMapping("/api/eksperci")
@RequiredArgsConstructor
public class EkspertIPMAController {

    private final EkspertIPMAService ekspertIPMAService;

    @PostMapping("/import")
    public ResponseDTO importEksperci(@RequestBody List<EkspertIPMADTO> eksperci) {
        return ekspertIPMAService.importEksperci(eksperci);
    }
}
