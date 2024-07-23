package rezeptofant.backend.services;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rezeptofant.backend.entities.NutrientExtraInfo;
import rezeptofant.backend.repositories.NutrientExtraInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NutrientExtraInfoService {

    private final NutrientExtraInfoRepository nutrientExtraInfoRepository;

    public List<NutrientExtraInfo> findAll() {
        List<NutrientExtraInfo> result = new ArrayList<>();
        for (NutrientExtraInfo nutrientExtraInfo : nutrientExtraInfoRepository.findAll()) {
            result.add(nutrientExtraInfo);
        }

        return result;

    }

    @Nullable
    public NutrientExtraInfo findById(@Nonnull Long id) {
        Optional<NutrientExtraInfo> possibleNutrientExtraInfo = nutrientExtraInfoRepository.findById(id);
        return possibleNutrientExtraInfo.orElse(null);
    }

    public NutrientExtraInfo create(@Nonnull NutrientExtraInfo nutrientExtraInfo) {
        if (nutrientExtraInfo.getId() != null && findById(nutrientExtraInfo.getId()) != null) {
            return nutrientExtraInfo;
        }

        return nutrientExtraInfoRepository.save(nutrientExtraInfo);
    }

    @Nullable
    public NutrientExtraInfo update(@Nonnull NutrientExtraInfo nutrientExtraInfo) {
        if (nutrientExtraInfo.getId() == null || findById(nutrientExtraInfo.getId()) == null) {
            return null;
        }

        return nutrientExtraInfoRepository.save(nutrientExtraInfo);
    }

    @Nullable
    public NutrientExtraInfo delete(@Nonnull Long id) {
        NutrientExtraInfo nutrientExtraInfo = findById(id);
        if (nutrientExtraInfo == null) {
            return null;
        }

        nutrientExtraInfoRepository.deleteById(id);
        return nutrientExtraInfo;
    }


}
