package com.app.homebanking.dtos;

import com.app.homebanking.models.Client;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ClientDTO{
    //Properties or attributes
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    Set<AccountDTO> accounts = new HashSet<>();

    public ClientDTO(){
    };

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.accounts = client.getAccount().stream().map(AccountDTO::new).collect(toSet());
//        this.accounts = client.getAccounts()
//                              .stream()
//                              .map(account -> new AccountDTO(account))
//                              .collect(toSet());
    }
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<AccountDTO> getAccounts() {
        return accounts;
    }
}
