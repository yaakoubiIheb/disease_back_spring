package com.example.disease_backend.Controles;


import com.example.disease_backend.DTO.Disease;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class DiseaseController {

    @GetMapping("/disease/{name}")
    public ResponseEntity<Disease> getDisease(@PathVariable String name) {
        String url = "https://tools.cdc.gov/api/v2/resources/diseases/" + name;
        RestTemplate restTemplate = new RestTemplate();
        Disease disease = restTemplate.getForObject(url, Disease.class);
        return new ResponseEntity<Disease>(disease, HttpStatus.OK);
    }
}
