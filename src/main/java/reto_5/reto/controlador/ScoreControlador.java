package reto_5.reto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reto_5.reto.modelo.Reservation;
import reto_5.reto.servicios.ReservationService;

/**
 * 
 * @author Janus
 */
@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
public class ScoreControlador {

    @Autowired
    private ReservationService reservationService;

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation actualizar(@RequestBody Reservation reserva) {
        return reservationService.actualizarScore(reserva);
    }

}
