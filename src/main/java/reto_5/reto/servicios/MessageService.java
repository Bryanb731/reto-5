package reto_5.reto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto_5.reto.modelo.Message;
import reto_5.reto.repositorio.MessageRepository;

/**
 * 
 * @author Janus
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message salvar(Message mensaje) {
        if(mensaje.getIdMessage() == null) {
            messageRepository.salvar(mensaje);
        }else {
            Optional<Message> consultar = messageRepository.getMessage(mensaje.getIdMessage());
            if(consultar.isEmpty()) {
                return messageRepository.salvar(mensaje);
            }else {
                return mensaje;
            }
        }
        return mensaje;
    }

    public Message actualizar(Message mensaje) {
        if(mensaje.getIdMessage() != null) {
            Optional<Message> consulta = messageRepository.getMessage(mensaje.getIdMessage());
            if(!consulta.isEmpty()) {
                if(mensaje.getMessageText() != null) {
                    consulta.get().setMessageText(mensaje.getMessageText());
                }
                return messageRepository.salvar(consulta.get());
            }
        }
        return mensaje;
    }

    public boolean borrarMessage(int id) {
        Optional<Message> message = getMessage(id);
        if(!message.isEmpty()) {
            messageRepository.borrar(message.get());
            return true;
        }
        return false;
    }
    
}
