package reto_5.reto.repositorio;

import org.springframework.data.repository.CrudRepository;

import reto_5.reto.modelo.Bike;

/**
 * 
 * @author Janus
 */
public interface BikeCrudRepository extends CrudRepository<Bike, Integer> {
    
}
