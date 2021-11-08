package reto_5.reto.modelo;

/**
 * 
 * @author Janus
 */
public class ContarClient {

    private Long total;
    private Client client;

    public ContarClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
