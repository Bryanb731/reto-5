package reto_5.reto.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto_5.reto.modelo.Client;
import reto_5.reto.modelo.ContarClient;
import reto_5.reto.modelo.Reservation;

/**
 * 
 * @author Janus
 */
@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation salvar(Reservation reserva) {
        return reservationCrudRepository.save(reserva);
    }

    public void borrar(Reservation reserva) {
        reservationCrudRepository.delete(reserva);
    }

    public List<Reservation> getReservationByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getReservationByTime(Date fechaUno, Date fechaDos) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(fechaUno, fechaDos);
    }

    public List<ContarClient> getMayorReservation() {
        List<ContarClient> resultado = new ArrayList<>();
        List<Object[]> datos = reservationCrudRepository.countTotalReservationByClient();
        for(int i = 0; i < datos.size(); i++) {
            Long conteo = (Long) datos.get(i)[1];
            Client cliente = (Client) datos.get(i)[0];
            ContarClient contar = new ContarClient(conteo, cliente);
            resultado.add(contar);
        }
        return resultado;
    }
    
}
