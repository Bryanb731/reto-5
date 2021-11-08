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

import reto_5.reto.modelo.ContarClient;
import reto_5.reto.modelo.Reservation;
import reto_5.reto.modelo.StatusReservation;
import reto_5.reto.servicios.ReservationService;

/**
 * 
 * @author Janus
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationControlador {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservation() {
        return reservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation salvar(@RequestBody Reservation reserva) {
        return reservationService.salvar(reserva);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation actualizar(@RequestBody Reservation reserva) {
        return reservationService.actualizar(reserva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrar(@PathVariable("id") int id) {
        return reservationService.borrarReservation(id);
    }

    @GetMapping("/report-status")
    public StatusReservation getStatus() {
        return reservationService.getStatus();
    }

    @GetMapping("/report-clients")
    public List<ContarClient> getCountClient() {
        return reservationService.getMayorReservation();
    }

    @GetMapping("/report-dates/{fechaUno}/{fechaDos}")
    public List<Reservation> getFecha(@PathVariable("fechaUno")String fecha1, @PathVariable("fechaDos")String fecha2) {
        return reservationService.getReservationByTime(fecha1, fecha2);
    }

}
