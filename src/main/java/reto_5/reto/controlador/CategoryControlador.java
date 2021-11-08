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

import reto_5.reto.modelo.Category;
import reto_5.reto.servicios.CategoryService;

/**
 * 
 * @author Janus
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryControlador {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategory() {
        return categoryService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category salvar(@RequestBody Category categoria) {
        return categoryService.salvar(categoria);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category actualizar(@RequestBody Category categoria) {
        return categoryService.actualizar(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrar(@PathVariable("id") int id) {
        return categoryService.borrarCategory(id);
    }

}
