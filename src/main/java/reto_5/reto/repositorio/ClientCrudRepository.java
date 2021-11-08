package reto_5.reto.repositorio;

import org.springframework.data.repository.CrudRepository;

import reto_5.reto.modelo.Client;

/**
 * 
 * @author Janus
 */
public interface ClientCrudRepository  extends CrudRepository<Client, Integer> {
    
}
