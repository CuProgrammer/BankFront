package sample.asteralbank;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty
    private String name;
    @JsonProperty
    private Gender gender;
    @JsonProperty
    private LocalDate birthDate;

    public Person(String name, Gender gender, LocalDate birthDate)
    {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Person()
    {

    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }
}