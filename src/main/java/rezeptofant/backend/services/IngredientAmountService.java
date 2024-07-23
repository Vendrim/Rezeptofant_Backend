package rezeptofant.backend.services;

import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rezeptofant.backend.entities.IngredientAmount;
import rezeptofant.backend.repositories.IngredientAmountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientAmountService {

    private final IngredientAmountRepository ingredientAmountRepository;

    public List<IngredientAmount> getAll() {

        Iterable<IngredientAmount> iterable = ingredientAmountRepository.findAll();

        List<IngredientAmount> ingredientAmounts = new ArrayList<>();

        for (IngredientAmount iterated : iterable) {
            ingredientAmounts.add(iterated);
        }

        return ingredientAmounts;
    }


    @Nullable
    public IngredientAmount findById(Long id) {
        Optional<IngredientAmount> ingredientAmount = ingredientAmountRepository.findById(id);
        return ingredientAmount.orElse(null);

    }

    @Transactional
    @Nullable
    public IngredientAmount create(IngredientAmount ingredientAmount) {

        if (ingredientAmount.getId() != null) {
            return ingredientAmount;
        }

        return ingredientAmountRepository.save(ingredientAmount);
    }

    @Transactional
    @Nullable
    public IngredientAmount update(IngredientAmount ingredientAmount) {
        Optional<IngredientAmount> possibleIngredientAmount = ingredientAmountRepository.findById(ingredientAmount.getId());

        if (possibleIngredientAmount.isEmpty()) {
            return null;
        }

        Long id = possibleIngredientAmount.get().getId();
        ingredientAmount.setId(id);
        ingredientAmountRepository.deleteById(id);

        return ingredientAmountRepository.save(ingredientAmount);

    }

    @Transactional
    @Nullable
    public IngredientAmount delete(Long id) {
        Optional<IngredientAmount> possibleIngredientAmount = ingredientAmountRepository.findById(id);
        if (possibleIngredientAmount.isEmpty()) {
            return null;
        }
        IngredientAmount ingredientInDatabase = possibleIngredientAmount.get();

        ingredientAmountRepository.deleteById(ingredientInDatabase.getId());

        return ingredientInDatabase;
    }

}
