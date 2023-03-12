package ru.mtsbank.testproject.data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.util.List;

public class Client {

    private Integer id;
    @NotEmpty(message = "Lastname should not be empty")
    private String lastName;
    @NotEmpty(message = "Name should not be empty")
    private String firstName;
    @NotEmpty(message = "Patronymic should not be empty")
    private String patronymic;
    @NotNull
    private String documentType;
    @NotEmpty(message = "Series and document number should not be empty")
    private String seriesAndDocumentNumber;
    @NotEmpty(message = "Series and document number should not be empty")
    @NotNull
    private Date dateOfBirth;
    private List<Account> accounts;

    public Client() {
    }

    public Client(String lastName, String firstName, String patronymic, String documentType, String seriesAndDocumentNumber, Date dateOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.documentType = documentType;
        this.seriesAndDocumentNumber = seriesAndDocumentNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getSeriesAndDocumentNumber() {
        return seriesAndDocumentNumber;
    }

    public void setSeriesAndDocumentNumber(String seriesAndDocumentNumber) {
        this.seriesAndDocumentNumber = seriesAndDocumentNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", documentType='" + documentType + '\'' +
                ", seriesAndDocumentNumber='" + seriesAndDocumentNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", accounts=" + accounts +
                '}';
    }
}