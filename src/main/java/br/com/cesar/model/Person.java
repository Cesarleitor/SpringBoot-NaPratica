package br.com.cesar.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "primeiro_nome", nullable = false, length = 80)
    private String primeiroNome;

    @Column(name = "segundo_nome", nullable = false, length = 80)
    private String segundoNome;

    @Column(name = "telefone", nullable = false, length = 80)
    private String telefone;

    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;

    @Column(name = "sexo", nullable = false, length = 10)
    private String sexo;

    @Column(name = "aniverssario", nullable = false)
    private LocalDate aniverssario;

    public Person() {
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

    public LocalDate getAniverssario() {
        return aniverssario;
    }

    public void setAniverssario(LocalDate aniverssario) {
        this.aniverssario = aniverssario;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && Objects.equals(getPrimeiroNome(), person.getPrimeiroNome()) && Objects.equals(getSegundoNome(), person.getSegundoNome()) && Objects.equals(getTelefone(), person.getTelefone()) && Objects.equals(getEndereco(), person.getEndereco()) && Objects.equals(getSexo(), person.getSexo()) && Objects.equals(getAniverssario(), person.getAniverssario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrimeiroNome(), getSegundoNome(), getTelefone(), getEndereco(), getSexo(), getAniverssario());
    }
}
