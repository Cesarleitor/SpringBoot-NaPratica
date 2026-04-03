package br.com.cesar.services;


import br.com.cesar.data.dto.v1.PersonDTO;
import br.com.cesar.exception.ResourseNotFoudException;
import static br.com.cesar.mapper.ObjectMapper.parseListObject;
import static br.com.cesar.mapper.ObjectMapper.parseObject;

import br.com.cesar.model.Person;
import br.com.cesar.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;



@Service
public class PersonServices {

    private final AtomicLong couter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;



    public List<PersonDTO> findAll(){
        logger.info("Encontrando todas as pessoas");

        return parseListObject(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Buscando uma pessoa!");

        var entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourseNotFoudException
                                ("Nenhum registro encontrado para este ID."));
        return  parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {

        logger.info("Criando uma pessoa!");
        if (person.getAniverssario() == null) {
            person.setAniverssario(LocalDate.now());
        }
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }


    public PersonDTO update(PersonDTO person) {

        logger.info("Atualizar uma pessoa!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() ->
                new ResourseNotFoudException
                        ("Nenhum registro encontrado para este ID."));


        entity.setPrimeiroNome(person.getPrimeiroNome());
        entity.setSegundoNome(person.getSegundoNome());
        entity.setTelefone(person.getTelefone());
        entity.setEndereco(person.getEndereco());
        entity.setSexo(person.getSexo());
        entity.setAniverssario(person.getAniverssario() != null ? person.getAniverssario() : entity.getAniverssario());

        return parseObject(repository.save(entity), PersonDTO.class);
    }


    public void delete(Long id) {

        logger.info("Deletar uma pessoa!");

        Person entity = repository.findById(id)
            .orElseThrow(() -> new ResourseNotFoudException
                    ("Nenhum registro encontrado para este ID."));
        repository.delete(entity);

    }

 }
