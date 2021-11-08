package reto_5.reto.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import reto_5.reto.modelo.Reservation;

/**
 * 
 * @author Janus
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date fechaUno, Date fechaDos);
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient();
    public List<Reservation> findAllByStatus(String status);
    
}
