package com.solvd.sciencelab;

public class Client {
    private int ClientId;
    private String firstName;
    private String lastName;

    public Client() {
    }

    public Client(int clientId, String firstName, String lastName) {
        ClientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ClientId=" + ClientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
