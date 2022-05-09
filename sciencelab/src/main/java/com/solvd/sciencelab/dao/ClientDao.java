package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClientDao implements Dao<Client>{

    private List<Client> clients = new ArrayList<>();

    @Override
    public Optional<Client> get(long id) {
        return Optional.ofNullable(clients.get((int) id));
    }

    @Override
    public List<Client> getAll() {
        return clients;
    }

    @Override
    public void save(Client client) {
        clients.add(client);
    }

    @Override
    public void update(Client client, String[] params) {
        client.setFirstName(Objects.requireNonNull(
                params[0], "cannot be null"));
        client.setLastName(Objects.requireNonNull(
                params[1], "cannot be null"));

        clients.add(client);
    }

    @Override
    public void delete(Client client) {
        clients.remove(client);
    }
}
