package rezeptofant.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rezeptofant.backend.entities.IngredientAmount;
import rezeptofant.backend.services.IngredientAmountService;
import rezeptofant.backend.util.Endpoints;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IngredientAmountController {

    private final IngredientAmountService ingredientAmountService;

    @GetMapping(Endpoints.INGREDIENT_AMOUNT + Endpoints.GET_ALL)
    public List<IngredientAmount> getAll() {
        return ingredientAmountService.getAll();
    }
}
