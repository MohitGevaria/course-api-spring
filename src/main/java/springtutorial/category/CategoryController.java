package springtutorial.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categories")
    public List<Category> getAll(){
        return categoryService.getAllCategories();
    }

    @RequestMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable String id){
        return categoryService.getCategory(id);
    }

    @RequestMapping(method=RequestMethod.POST, value = "/categories")
    public String addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return "Category Added Successfully";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/categories/{id}")
    public String deleteCategory(@PathVariable String id){
        categoryService.deleteCategory(id);
        return "Category deleted.";
    }

}
