package reto_5.reto.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Janus
 */
@Entity
@Table(name = "bicicletas")
public class Bike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties("bikes")
    private Category category; // <- mappedBy

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike") // <- relacion con Message
    @JsonIgnoreProperties({"bike", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike")
    @JsonIgnoreProperties({"bike", "message"})
    private List<Reservation> reservations;

    /**
     * 
     * @return metodo para regresar id de bike
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id recibe valor entero de id de bike
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return que regresa el nombre de bike
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name recibe el nombre en String de bike
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return regresa un valor de tipo String de brand de bike
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 
     * @param brand recibe el valor de brand de bike tipo String
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 
     * @return regresa valor de tipo entero de año
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 
     * @param year recibe valor de tipo entero de año
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 
     * @return regresa valor String de descripcion
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description recibe valor de tipo String de descripcion
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return regresa un objeto de tipo categoria
     */
    public Category getCategory() {
        return category;
    }

    /**
     * 
     * @param category recibe un objeto de tipo categoria
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * 
     * @return regresa una lista de mensajes
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * 
     * @param messages recibe una lista de mensajes
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * 
     * @return regresa una lista de reservas
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * 
     * @param reservations recibe una lista de reservas
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
