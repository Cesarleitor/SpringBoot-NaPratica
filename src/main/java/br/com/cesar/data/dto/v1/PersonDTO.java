package br.com.cesar.data.dto.v1;

import br.com.cesar.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;



public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String primeiroNome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String segundoNome;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String telefone;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate aniverssario;

    private String endereco;

    @JsonSerialize(using = GenderSerializer.class)
    private String sexo;

    public PersonDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSegundoNome() {
        return segundoNome;
    }

    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getAniverssario() {
        return aniverssario;
    }

    public void setAniverssario(LocalDate aniverssario) {
        this.aniverssario = aniverssario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return getId() == personDTO.getId() && Objects.equals(getPrimeiroNome(), personDTO.getPrimeiroNome()) && Objects.equals(getSegundoNome(), personDTO.getSegundoNome()) && Objects.equals(getTelefone(), personDTO.getTelefone()) && Objects.equals(getAniverssario(), personDTO.getAniverssario()) && Objects.equals(getEndereco(), personDTO.getEndereco()) && Objects.equals(getSexo(), personDTO.getSexo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrimeiroNome(), getSegundoNome(), getTelefone(), getAniverssario(), getEndereco(), getSexo());
    }
}


