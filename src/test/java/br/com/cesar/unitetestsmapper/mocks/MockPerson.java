package br.com.cesar.unitetestsmapper.mocks;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import br.com.cesar.data.dto.v1.PersonDTO;
import br.com.cesar.model.Person;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDTO> mockDTOList() {
        List<PersonDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }
    
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setEndereco("Endereco Test" + number);
        person.setPrimeiroNome("Primeiro Nome Test" + number);
        person.setSexo(((number % 2)==0) ? "Masculino" : "Feminino");
        person.setId(number.longValue());
        person.setSegundoNome("Segundo Nome Test" + number);
        person.setTelefone("+55 (54) 99999-10" + String.format("%02d", number));
        person.setAniverssario(LocalDate.of(2024, 1, 1).plusDays(number.longValue()));
        return person;
    }

    public PersonDTO mockDTO(Integer number) {
        PersonDTO person = new PersonDTO();
        person.setEndereco("Endereco Test" + number);
        person.setPrimeiroNome("Primeiro Nome Test" + number);
        person.setSexo(((number % 2)==0) ? "Masculino" : "Feminino");
        person.setId(number.longValue());
        person.setSegundoNome("Segundo Nome Test" + number);
        person.setTelefone("+55 (54) 99999-10" + String.format("%02d", number));
        person.setAniverssario(LocalDate.of(2024, 1, 1).plusDays(number.longValue()));
        return person;
    }

}
