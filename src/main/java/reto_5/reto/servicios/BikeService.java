package reto_5.reto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto_5.reto.modelo.Bike;
import reto_5.reto.repositorio.BikeRepository;

/**
 * 
 * @author Janus
 */
@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getll() {
        return bikeRepository.getAll();
    }

    public Optional<Bike> getBike(int id) {
        return bikeRepository.getBike(id);
    }

    public Bike salvar(Bike bicicleta) {
        if(bicicleta.getId() == null) {
            bikeRepository.salvar(bicicleta);
        }else {
            Optional<Bike> consultar = bikeRepository.getBike(bicicleta.getId());
            if(consultar.isEmpty()) {
                return bikeRepository.salvar(bicicleta);
            }else {
                return bicicleta;
            }
        }
        return bicicleta;
    }

    public Bike actualizar(Bike bicicleta) {
        if(bicicleta.getId() != null) {
            Optional<Bike> consulta = bikeRepository.getBike(bicicleta.getId());
            if(!consulta.isEmpty()) {
                if(bicicleta.getName() != null) {
                    consulta.get().setName(bicicleta.getName());
                }
                if(bicicleta.getBrand() != null) {
                    consulta.get().setBrand(bicicleta.getBrand());
                }
                if(bicicleta.getYear() != null) {
                    consulta.get().setYear(bicicleta.getYear());
                }
                if(bicicleta.getDescription() != null) {
                    consulta.get().setDescription(bicicleta.getDescription());
                }
                return bikeRepository.salvar(consulta.get());
            }
        }
        return bicicleta;
    }

    public boolean borrarBike(int id) {
        Optional<Bike> bike = getBike(id);
        if(!bike.isEmpty()) {
            bikeRepository.borrar(bike.get());
            return true;
        }
        return false;
    }

}
