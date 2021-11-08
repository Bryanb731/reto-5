package reto_5.reto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto_5.reto.modelo.Client;

/**
 * 
 * @author Janus
 */
@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id) {
        return clientCrudRepository.findById(id);
    }

    public Client salvar(Client cliente) {
        return clientCrudRepository.save(cliente);
    }

    public void borrar(Client cliente) {
        clientCrudRepository.delete(cliente);
    }
    
}
