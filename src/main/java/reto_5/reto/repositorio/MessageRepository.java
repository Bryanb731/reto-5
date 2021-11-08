package reto_5.reto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto_5.reto.modelo.Message;

/**
 * 
 * @author Janus
 */
@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageCrudRepository.findById(id);
    }

    public Message salvar(Message mensaje) {
        return messageCrudRepository.save(mensaje);
    }

    public void borrar(Message mensaje) {
        messageCrudRepository.delete(mensaje);
    }
    
}
