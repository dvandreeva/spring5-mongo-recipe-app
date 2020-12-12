package guru.springframework.services;

import guru.springframework.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    Set<Category> findAll();
    Category findById(String id);
    List<String> getSelectedCategoriesId(String recipeId);
}
