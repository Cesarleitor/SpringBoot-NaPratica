package br.com.cesar.services;

import br.com.cesar.exception.ResourseNotFoudException;
import br.com.cesar.model.Person;
import br.com.cesar.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong couter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;


    public List<Person> findAll(){
        logger.info("Encontrando todas as pessoas");

        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Encontrando uma pessoa!");

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourseNotFoudException
                                ("Nenhum registro encontrado para este ID."));
    }

    public Person create(Person person) {

        logger.info("Criando uma pessoa!");

        return repository.save(person);
    }
    public Person update(Person person) {

        logger.info("Atualizar uma pessoa!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() ->
                new ResourseNotFoudException
                        ("Nenhum registro encontrado para este ID."));


        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }


    public void delete(Long id) {

        logger.info("Deletar uma pessoa!");

        Person entity = repository.findById(id)
            .orElseThrow(() -> new ResourseNotFoudException
                    ("Nenhum registro encontrado para este ID."));
        repository.delete(entity);

    }

 }
