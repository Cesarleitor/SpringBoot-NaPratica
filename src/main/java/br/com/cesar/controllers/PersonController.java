package br.com.cesar.controllers;



import br.com.cesar.data.dto.v1.PersonDTO;
import br.com.cesar.data.dto.v2.PersonDTOv2;
import br.com.cesar.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired // VAI INJETAR A INSTÂNCIA DE SERVICE QUANDO FOR NECESSÁRIO
    private PersonServices service;

    // BUSCAR DADOS
    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll() {return service.findAll();}

    // BUSCAR DADOS
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO findiById(@PathVariable ("id") Long id) {
        return service.findById(id);
    }

    // CRIAR OS DADOS
    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    // CRIAR OS DADOS
    @PostMapping( value = "/v2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTOv2 create(@RequestBody PersonDTOv2 person) {
        return service.createV2(person);
    }

    //ATUALIZAR OS DADOS
    @PutMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update(@RequestBody PersonDTO person) {
        return service.update(person);
    }

    // EXCLUIR DADOS
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
