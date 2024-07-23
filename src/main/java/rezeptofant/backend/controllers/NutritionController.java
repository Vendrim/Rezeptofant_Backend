package rezeptofant.backend.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rezeptofant.backend.entities.IngredientAmount;
import rezeptofant.backend.services.IngredientAmountService;
import rezeptofant.backend.util.Endpoints;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class NutritionController {
    private final IngredientAmountService ingredientAmountService;

    @GetMapping(Endpoints.INGREDIENT_AMOUNT + Endpoints.GET_ALL)
    public List<IngredientAmount> getAll() {
        return ingredientAmountService.getAll();
    }

    @GetMapping(Endpoints.INGREDIENT_AMOUNT + Endpoints.GET + "/{id}")
    public IngredientAmount get(@PathVariable("id") Long id) {
        return ingredientAmountService.findById(id);
    }

    @PostMapping(Endpoints.INGREDIENT_AMOUNT + Endpoints.CREATE)
    public IngredientAmount create(IngredientAmount ingredient) {
        return ingredientAmountService.create(ingredient);
    }

    @PutMapping(Endpoints.INGREDIENT_AMOUNT + Endpoints.UPDATE)
    public IngredientAmount update(IngredientAmount ingredient) {
        if (ingredient.getId() == null) {
            return null;
        }

        return ingredientAmountService.update(ingredient);
    }

    @DeleteMapping(Endpoints.INGREDIENT_AMOUNT + Endpoints.DELETE + "/{id}")
    public IngredientAmount delete(@PathVariable("id") Long id) {
        if (id == null || id < 1 || id == Integer.MAX_VALUE || id == Integer.MIN_VALUE) {
            return null;
        }

        return ingredientAmountService.delete(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
    }
}
