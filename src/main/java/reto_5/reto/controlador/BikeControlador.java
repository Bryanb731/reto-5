package reto_5.reto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reto_5.reto.modelo.Bike;
import reto_5.reto.servicios.BikeService;

/**
 * 
 * @author Janus
 */
@RestController
@RequestMapping("/api/Bike")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BikeControlador {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/all")
    public List<Bike> getBike() {
        return bikeService.getll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike salvar(@RequestBody Bike bicicleta) {
        return bikeService.salvar(bicicleta);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike actualizar(@RequestBody Bike bicicleta) {
        return bikeService.actualizar(bicicleta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrar(@PathVariable("id") int id) {
        return bikeService.borrarBike(id);
    }

}
