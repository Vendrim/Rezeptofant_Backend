package rezeptofant.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import rezeptofant.backend.entities.Nutrition;

public interface NutritionRepository extends CrudRepository<Nutrition, Long> {
}
