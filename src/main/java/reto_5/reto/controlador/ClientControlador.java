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

import reto_5.reto.modelo.Client;
import reto_5.reto.servicios.ClientService;

/**
 * 
 * @author Janus
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientControlador {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClient() {
        return clientService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client salvar(@RequestBody Client cliente) {
        return clientService.salvar(cliente);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client actualizar(@RequestBody Client cliente) {
        return clientService.actualizar(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrar(@PathVariable("id") int id) {
        return clientService.borrarClient(id);
    }
    
}
