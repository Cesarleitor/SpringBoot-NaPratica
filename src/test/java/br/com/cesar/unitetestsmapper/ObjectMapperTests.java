package br.com.cesar.unitetestsmapper;
import static br.com.cesar.mapper.ObjectMapper.parseListObject;
import static br.com.cesar.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import br.com.cesar.unitetestsmapper.mocks.MockPerson;
import br.com.cesar.data.dto.v1.PersonDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cesar.model.Person;

public class ObjectMapperTests {
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToDTOTest() {
        PersonDTO output = parseObject(inputObject.mockEntity(), PersonDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Primeiro Nome Test0", output.getPrimeiroNome());
        assertEquals("Segundo Nome Test0", output.getSegundoNome());
        assertEquals("+55 (54) 99999-1000", output.getTelefone());
        assertEquals("Endereco Test0", output.getEndereco());
        assertEquals("Masculino", output.getSexo());
        assertEquals(inputObject.mockEntity().getAniverssario(), output.getAniverssario());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<PersonDTO> outputList = parseListObject(inputObject.mockEntityList(), PersonDTO.class);
        PersonDTO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Primeiro Nome Test0", outputZero.getPrimeiroNome());
        assertEquals("Segundo Nome Test0", outputZero.getSegundoNome());
        assertEquals("+55 (54) 99999-1000", outputZero.getTelefone());
        assertEquals("Endereco Test0", outputZero.getEndereco());
        assertEquals("Masculino", outputZero.getSexo());
        assertEquals(inputObject.mockEntityList().get(0).getAniverssario(), outputZero.getAniverssario());

        PersonDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Primeiro Nome Test7", outputSeven.getPrimeiroNome());
        assertEquals("Segundo Nome Test7", outputSeven.getSegundoNome());
        assertEquals("+55 (54) 99999-1007", outputSeven.getTelefone());
        assertEquals("Endereco Test7", outputSeven.getEndereco());
        assertEquals("Feminino", outputSeven.getSexo());
        assertEquals(inputObject.mockEntityList().get(7).getAniverssario(), outputSeven.getAniverssario());

        PersonDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Primeiro Nome Test12", outputTwelve.getPrimeiroNome());
        assertEquals("Segundo Nome Test12", outputTwelve.getSegundoNome());
        assertEquals("+55 (54) 99999-1012", outputTwelve.getTelefone());
        assertEquals("Endereco Test12", outputTwelve.getEndereco());
        assertEquals("Masculino", outputTwelve.getSexo());
        assertEquals(inputObject.mockEntityList().get(12).getAniverssario(), outputTwelve.getAniverssario());
    }

    @Test
    public void parseDTOToEntityTest() {
        Person output = parseObject(inputObject.mockDTO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Primeiro Nome Test0", output.getPrimeiroNome());
        assertEquals("Segundo Nome Test0", output.getSegundoNome());
        assertEquals("+55 (54) 99999-1000", output.getTelefone());
        assertEquals("Endereco Test0", output.getEndereco());
        assertEquals("Masculino", output.getSexo());
        assertEquals(inputObject.mockDTO().getAniverssario(), output.getAniverssario());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Person> outputList = parseListObject(inputObject.mockDTOList(), Person.class);
        Person outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Primeiro Nome Test0", outputZero.getPrimeiroNome());
        assertEquals("Segundo Nome Test0", outputZero.getSegundoNome());
        assertEquals("+55 (54) 99999-1000", outputZero.getTelefone());
        assertEquals("Endereco Test0", outputZero.getEndereco());
        assertEquals("Masculino", outputZero.getSexo());
        assertEquals(inputObject.mockDTOList().get(0).getAniverssario(), outputZero.getAniverssario());

        Person outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Primeiro Nome Test7", outputSeven.getPrimeiroNome());
        assertEquals("Segundo Nome Test7", outputSeven.getSegundoNome());
        assertEquals("+55 (54) 99999-1007", outputSeven.getTelefone());
        assertEquals("Endereco Test7", outputSeven.getEndereco());
        assertEquals("Feminino", outputSeven.getSexo());
        assertEquals(inputObject.mockDTOList().get(7).getAniverssario(), outputSeven.getAniverssario());

        Person outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Primeiro Nome Test12", outputTwelve.getPrimeiroNome());
        assertEquals("Segundo Nome Test12", outputTwelve.getSegundoNome());
        assertEquals("+55 (54) 99999-1012", outputTwelve.getTelefone());
        assertEquals("Endereco Test12", outputTwelve.getEndereco());
        assertEquals("Masculino", outputTwelve.getSexo());
        assertEquals(inputObject.mockDTOList().get(12).getAniverssario(), outputTwelve.getAniverssario());
    }
}
