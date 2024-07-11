package rezeptofant.backend.services;

import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import rezeptofant.backend.entities.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rezeptofant.backend.repositories.IngredientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> findAll() {
        Iterable<Ingredient> iterables = ingredientRepository.findAll();
        List<Ingredient> result = new ArrayList<>();

        for (Ingredient ingredient : iterables) {
            result.add(ingredient);
        }

        return result;
    }

    @Nullable
    public Ingredient findByName(String name) {
        Optional<Ingredient> possibleIngredient = ingredientRepository.findByName(name);
        return possibleIngredient.orElse(null);

    }

    @Transactional
    @Nullable
    public Ingredient create(Ingredient ingredient) {

        if (ingredient.getId() != null) {
            return ingredient;
        }

        if (ingredientRepository.findByName(ingredient.getName()).isPresent()) {
            return null;
        }

        return ingredientRepository.save(ingredient);
    }

    @Transactional
    @Nullable
    public Ingredient update(Ingredient ingredient) {
        Optional<Ingredient> possibleIngredient = ingredientRepository.findByName(ingredient.getName());

        if (possibleIngredient.isEmpty()) {
            return null;
        }

        Ingredient ingredientInDatabase = possibleIngredient.get().updateValuesFromOtherIngredient(ingredient);

        return ingredientRepository.save(ingredientInDatabase);

    }

    @Transactional
    @Nullable
    public Ingredient delete(String name) {
        Optional<Ingredient> possibleIngredient = ingredientRepository.findByName(name);
        if (possibleIngredient.isEmpty()) {
            return null;
        }
        Ingredient ingredientInDatabase = possibleIngredient.get();

        ingredientRepository.deleteById(ingredientInDatabase.getId());

        return ingredientInDatabase;
    }
}
