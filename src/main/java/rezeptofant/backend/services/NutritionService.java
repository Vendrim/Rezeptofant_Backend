package rezeptofant.backend.services;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rezeptofant.backend.entities.Nutrition;
import rezeptofant.backend.repositories.NutritionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NutritionService {

    private final NutritionRepository nutritionRepository;

    public List<Nutrition> findAll() {
        List<Nutrition> result = new ArrayList<>();
        for (Nutrition nutrition : nutritionRepository.findAll()) {
            result.add(nutrition);
        }

        return result;
    }

    @Nullable
    public Nutrition findById(@Nonnull Long id) {
        Optional<Nutrition> possibleNutrition = nutritionRepository.findById(id);
        return possibleNutrition.orElse(null);
    }

    public Nutrition create(@Nonnull Nutrition nutrition) {
        if (nutrition.getId() != null && findById(nutrition.getId()) != null) {
            return nutrition;
        }

        return nutritionRepository.save(nutrition);
    }

    @Nullable
    public Nutrition update(@Nonnull Nutrition nutrition) {
        if (nutrition.getId() == null || findById(nutrition.getId()) == null) {
            return null;
        }

        return nutritionRepository.save(nutrition);

    }

    @Nullable
    public Nutrition delete(@Nonnull Long id) {
        Nutrition nutrition = findById(id);
        if (nutrition == null) {
            return null;
        }

        nutritionRepository.deleteById(id);
        return nutrition;
    }




}
