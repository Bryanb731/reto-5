package reto_5.reto.modelo;

/**
 * 
 * @author Janus
 */
public class StatusReservation {

    /**
     * Atributo privado entero completed
     */
    private int completed;
    /**
     * atributo privado entero cancelled
     */
    private int cancelled;

    /**
     * 
     * @param completed recibe valor entero de completed
     * @param cancelled recibe valor entero de cancelled
     */ 
    public StatusReservation(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    /**
     * 
     * @return regresa valor entero de completed
     */
    public int getCompleted() {
        return completed;
    }

    /**
     * 
     * @param completed recibe un valor entero de completed
     */
    public void setCompleted(int completed) {
        this.completed = completed;
    }

    /**
     * 
     * @return regresa valor entero de cancelled
     */
    public int getCancelled() {
        return cancelled;
    }

    /**
     * 
     * @param cancelled recibe un valor entero de cancelled
     */
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

}
