package reto_5.reto.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto_5.reto.modelo.Category;
import reto_5.reto.repositorio.CategoryRepository;

/**
 * 
 * @author Janus
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category salvar(Category categoria) {
        if(categoria.getId() == null) {
            categoryRepository.salvar(categoria);
        }else {
            Optional<Category> consultar = categoryRepository.getCategory(categoria.getId());
            if(consultar.isEmpty()) {
                return categoryRepository.salvar(categoria);
            }else {
                return categoria;
            }
        }
        return categoria;
    }

    public Category actualizar(Category categoria) {
        if(categoria.getId() != null) {
            Optional<Category> consulta = categoryRepository.getCategory(categoria.getId());
            if(!consulta.isEmpty()) {
                if(categoria.getName() != null) {
                    consulta.get().setName(categoria.getName());
                }
                if(categoria.getDescription() != null) {
                    consulta.get().setDescription(categoria.getDescription());
                }
                return categoryRepository.salvar(consulta.get());
            }
        }
        return categoria;
    }

    public boolean borrarCategory(int id) {
        Optional<Category> category = getCategory(id);
        if(!category.isEmpty()) {
            categoryRepository.borrar(category.get());
            return true;
        }
        return false;
    }

}
