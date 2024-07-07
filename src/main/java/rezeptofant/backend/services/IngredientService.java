package rezeptofant.backend.services;

import rezeptofant.backend.entities.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rezeptofant.backend.repositories.IngredientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> findAll() {
       Iterable<Ingredient> iterables = ingredientRepository.findAll();
       List<Ingredient> result = new ArrayList<>();

       for(Ingredient ingredient : iterables) {
           result.add(ingredient);
       }

       return result;
    }





}
