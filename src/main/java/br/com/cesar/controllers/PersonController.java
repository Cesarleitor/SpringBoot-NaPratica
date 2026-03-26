package br.com.cesar.controllers;


import br.com.cesar.services.PersonServices;
import br.com.cesar.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired // VAI INJETAR A INSTÂNCIA DE SERVICE QUANDO FOR NECESSÁRIO
    private PersonServices service;

    // BUSCAR DADOS
    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {return service.findAll();}

    // BUSCAR DADOS
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findiById(@PathVariable ("id") Long id) {
        return service.findById(id);
    }

    // CRIAR OS DADOS
    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    //ATUALIZAR OS DADOS
    @PutMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    // EXCLUIR DADOS
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
