package reto_5.reto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto_5.reto.modelo.Category;

/**
 * 
 * @author Janus
 */
@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryCrudRepository.findById(id);
    }

    public Category salvar(Category categoria) {
        return categoryCrudRepository.save(categoria);
    }

    public void borrar(Category categoria) {
        categoryCrudRepository.delete(categoria);
    }

}
