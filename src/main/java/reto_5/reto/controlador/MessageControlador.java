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

import reto_5.reto.modelo.Message;
import reto_5.reto.servicios.MessageService;

/**
 * 
 * @author Janus
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageControlador {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMessage() {
        return messageService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message salvar(@RequestBody Message mensaje) {
        return messageService.salvar(mensaje);
    }

    @PutMapping("/uppdate")
    @ResponseStatus(HttpStatus.CREATED)
    public Message actualizar(@RequestBody Message mensaje) {
        return messageService.actualizar(mensaje);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrar(@PathVariable("id") int id) {
        return messageService.borrarMessage(id);
    }
    
}
