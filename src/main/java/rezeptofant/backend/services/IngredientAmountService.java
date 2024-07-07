package rezeptofant.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rezeptofant.backend.entities.IngredientAmount;
import rezeptofant.backend.repositories.IngredientAmountRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientAmountService {

    private final IngredientAmountRepository ingredientAmountRepository;

    public List<IngredientAmount> getAll() {

        Iterable<IngredientAmount> iterable = ingredientAmountRepository.findAll();

        List<IngredientAmount> ingredientAmounts = new ArrayList<>();

        for(IngredientAmount iterated : iterable) {
            ingredientAmounts.add(iterated);
        }

        return ingredientAmounts;
    }


}
