package reto_5.reto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto_5.reto.modelo.Client;
import reto_5.reto.repositorio.ClientRepository;

/**
 * 
 * @author Janus
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client salvar(Client cliente) {
        if(cliente.getIdClient() == null) {
            clientRepository.salvar(cliente);
        }else {
            Optional<Client> consutar = clientRepository.getClient(cliente.getIdClient());
            if(consutar.isEmpty()) {
                return clientRepository.salvar(cliente);
            }else {
                return cliente;
            }
        }
        return cliente;
    }

    public Client actualizar(Client cliente) {
        if(cliente.getIdClient() != null) {
            Optional<Client> consulta = clientRepository.getClient(cliente.getIdClient());
            if(!consulta.isEmpty()) {
                if(cliente.getEmail() != null) {
                    consulta.get().setEmail(cliente.getEmail());
                }
                if(cliente.getPassword() != null) {
                    consulta.get().setPassword(cliente.getPassword());
                }
                if(cliente.getName() != null) {
                    consulta.get().setName(cliente.getName());
                }
                if(cliente.getAge() != null) {
                    consulta.get().setAge(cliente.getAge());
                }
                return clientRepository.salvar(consulta.get());
            }
        }
        return cliente;
    }

    public boolean borrarClient(int id) {
        Optional<Client> client = getClient(id);
        if(!client.isEmpty()) {
            clientRepository.borrar(client.get());
            return true;
        }
        return false;
    }
    
}
