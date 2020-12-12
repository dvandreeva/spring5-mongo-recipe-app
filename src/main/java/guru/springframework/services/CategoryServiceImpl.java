package guru.springframework.services;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import guru.springframework.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryServiceImpl  implements CategoryService {
    CategoryRepository categoryRepository;
    RecipeService recipeService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.recipeService = recipeService;
    }

    @Override
    public Set<Category> findAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public Category findById(String id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<String> getSelectedCategoriesId(String recipeId) {
        List<String> selectedCatsId = new ArrayList<>();
        for(CategoryCommand command : recipeService.findCommandById(recipeId).getCategories()) {
            selectedCatsId.add(command.getId());
        }
        return selectedCatsId;
    }
}

