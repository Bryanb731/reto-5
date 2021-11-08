package reto_5.reto.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto_5.reto.modelo.ContarClient;
import reto_5.reto.modelo.Reservation;
import reto_5.reto.modelo.StatusReservation;
import reto_5.reto.repositorio.ReservationRepository;

/**
 * 
 * @author Janus
 */
@Service
public class ReservationService {

    /**
     * 
     * instanciacion de repositorio de reservas
     */
    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * 
     * @return regresa todos los valores encontraos en el repositorio reservas
     */
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    /**
     * 
     * @param id recibe un valor entero que representa la id de la reserva
     * @return regresa la reserva que coincide con la id
     */
    public Optional<Reservation> getReservation(int idReserva) {
        return reservationRepository.getReservation(idReserva);
    }

    /**
     * 
     * @param reserva recibe un objeto de tipo Reservation
     * @return regresa el valor de una reserva sí existe
     */
    public Reservation salvar(Reservation reserva) {
        if(reserva.getIdReservation() == null) {
            reservationRepository.salvar(reserva);
        }else {
            Optional<Reservation> consultar = reservationRepository.getReservation(reserva.getIdReservation());
            if(consultar.isEmpty()) {
                return reservationRepository.salvar(reserva);
            }else {
                return reserva;
            }
        }
        return reserva;
    }

    /**
     * 
     * @param reservas recibe un objeto de tipo Reservation
     * @return regresa los valores correspondientes actualizados de la reserva sí existe en el repositorio
     */
    public Reservation actualizar(Reservation reservas) {
        if(reservas.getIdReservation() != null) {
            Optional<Reservation> consulta = reservationRepository.getReservation(reservas.getIdReservation());
            if(!consulta.isEmpty()) {
                if(reservas.getStartDate() != null) {
                    consulta.get().setStartDate(reservas.getStartDate());
                }
                if(reservas.getDevolutionDate() != null) {
                    consulta.get().setDevolutionDate(reservas.getDevolutionDate());
                }
                return reservationRepository.salvar(consulta.get());
            }
        }
        return reservas;
    }

    /**
     * 
     * @param reserva recibe un objeto que es de tipo Reservation
     * @return regresa una reserva sí existe con un nuevo valor de score
     */
    public Reservation actualizarScore(Reservation reserva) {
        if(reserva.getIdReservation() != null) {
            Optional<Reservation> consulta = reservationRepository.getReservation(reserva.getIdReservation());
            if(!consulta.isEmpty()) {
                if(reserva.getScore() != null) {
                    consulta.get().setScore(reserva.getScore());
                }
            }
            return reservationRepository.salvar(consulta.get());
        }
        return reserva;
    }

    /**
     * 
     * @param id recibe un valor de tipo entero que representa la id de la reserva
     * @return regresa un valor tipo booleano, verdadero si existe en repositorio y que se puede borrar, y falso si no existe
     */
    public boolean borrarReservation(int id) {
        Optional<Reservation> reservation = getReservation(id);
        if(!reservation.isEmpty()) {
            reservationRepository.borrar(reservation.get());
            return true;
        }
        return false;
    }

    /**
     * 
     * @return regresa el cliente con mas dinero en reserva
     */
    public List<ContarClient> getMayorReservation() {
        return reservationRepository.getMayorReservation();
    }

    /**
     * 
     * @return regresa el numero de reservas completadas y canceladas
     */
    public StatusReservation getStatus() {
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        StatusReservation cuenta = new StatusReservation(completed.size(), cancelled.size());
        return cuenta;
    }

    /**
     * 
     * @param fecha1 recibe el valor de inicio de una fecha
     * @param fecha2 recibe el valor de final de un periodo de una fecha
     * @return regresa una arraylist vacio en caso de detectarse que la primera fecha ingresada sea la de inicio de tiempo
     */
    public List<Reservation> getReservationByTime(String fecha1, String fecha2) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaUno = new Date();
        Date fechaDos = new Date();
        try {
            fechaUno = formato.parse(fecha1);
            fechaDos = formato.parse(fecha2);

        } catch(ParseException exception) {
            exception.printStackTrace();
        }
        if(fechaUno.before(fechaDos)) {
            return reservationRepository.getReservationByTime(fechaUno, fechaDos);
        } else {
            return new ArrayList<>();
        }
    }
    
}
