package reto_5.reto.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Janus
 */
@Entity
@Table(name = "mensajes")
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "bicicleta_id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Bike bike; // <- mappedBy

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client; // <- mappedBy

    public Integer getIdMessage() {
        return idMessage;
    }
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public Bike getBike() {
        return bike;
    }
    public void setBike(Bike bike) {
        this.bike = bike;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

}
