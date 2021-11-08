package reto_5.reto.repositorio;

import org.springframework.data.repository.CrudRepository;

import reto_5.reto.modelo.Category;

/**
 * 
 * @author Janus
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
    
}
