package rezeptofant.backend.controllers;

import org.springframework.web.bind.annotation.*;
import rezeptofant.backend.entities.Ingredient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import rezeptofant.backend.services.IngredientService;
import rezeptofant.backend.util.Endpoints;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping(Endpoints.INGREDIENTS + Endpoints.GET_ALL)
    public List<Ingredient> all() {
        return ingredientService.findAll();
    }

    @GetMapping(Endpoints.INGREDIENTS + Endpoints.GET + "/{name}")
    public Ingredient get(@PathVariable("name") String name) {
        return ingredientService.findByName(name);
    }

    @PostMapping(Endpoints.INGREDIENTS + Endpoints.CREATE)
    public Ingredient create(Ingredient ingredient) {
        return ingredientService.create(ingredient);
    }

     @PutMapping(Endpoints.INGREDIENTS + Endpoints.UPDATE)
     public Ingredient update(Ingredient ingredient) {
        if(ingredient.getId() == null) {
            return null;
        }

        return ingredientService.update(ingredient);
     }

     @DeleteMapping(Endpoints.INGREDIENTS + Endpoints.DELETE + "/{name}")
     public Ingredient delete(@PathVariable("name") String name) {
        if(name.isBlank() || name.isEmpty()) {
            return null;
        }

        return ingredientService.delete(name);
     }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
    }
}
