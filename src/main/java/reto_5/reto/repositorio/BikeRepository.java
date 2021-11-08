package reto_5.reto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto_5.reto.modelo.Bike;

/**
 * 
 * @author Janus
 */
@Repository
public class BikeRepository {

    @Autowired
    private BikeCrudRepository bikeCrudRepository;

    public List<Bike> getAll() {
        return (List<Bike>) bikeCrudRepository.findAll();
    }

    public Optional<Bike> getBike(int id) {
        return bikeCrudRepository.findById(id);
    }

    public Bike salvar(Bike bicicleta) {
        return bikeCrudRepository.save(bicicleta);
    }

    public void borrar(Bike bicicleta) {
        bikeCrudRepository.delete(bicicleta);
    }

}

