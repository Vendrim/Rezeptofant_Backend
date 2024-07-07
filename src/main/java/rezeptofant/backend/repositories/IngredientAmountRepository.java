package rezeptofant.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import rezeptofant.backend.entities.IngredientAmount;

public interface IngredientAmountRepository extends CrudRepository<IngredientAmount, Long> {
}
