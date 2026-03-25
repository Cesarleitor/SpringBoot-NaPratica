package br.com.cesar;

import br.com.cesar.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong couter = new AtomicLong();


    // PROVISÓRIO PARA POSTERIORMENTE TROCAR PELO BANCO DE DADOS
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Encontrando todas as pessoa!");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }



    public Person findById(String id) {
        logger.info("Encontrando uma pessoa!");

        Person person = new Person();
        person.setId(couter.incrementAndGet());
        person.setFirstName("Cesar");
        person.setLastName("Augusto");
        person.setAddress("Caxias do Sul - Rio Grande do Sul");
        person.setGender("Masculino");
        return person;
    }

    public Person create(Person person) {

        logger.info("Criando uma pessoa!");

        return person;
    }
    public Person update(Person person) {

        logger.info("Atualizar uma pessoa!");

        return person;
    }

    public void delete(String id) {
        logger.info("Deletar uma pessoa!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(couter.incrementAndGet());
        person.setFirstName("Firstname" + i);
        person.setLastName("Lastname" + i);
        person.setAddress(" Some Address in Brasil");
        person.setGender("Masculino");
        return person;
    }
}
