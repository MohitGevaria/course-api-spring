package springtutorial.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    public Category getCategory(String id){
        Optional<Category> category;
        category = categoryRepository.findById(id);
        return category.get();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category, String id)
    {
        categoryRepository.save(category);
    }

    public void deleteCategory(String id){
        categoryRepository.deleteById(id);
    }
}
