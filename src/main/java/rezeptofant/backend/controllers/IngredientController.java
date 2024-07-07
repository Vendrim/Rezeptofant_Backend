package rezeptofant.backend.controllers;

import rezeptofant.backend.entities.Ingredient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rezeptofant.backend.services.IngredientService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class IngredientController {


    private final IngredientService ingredientService;

    @GetMapping("/all")
    public List<Ingredient> all() {
        return ingredientService.findAll();
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
    }
}
