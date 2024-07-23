package rezeptofant.backend.services;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rezeptofant.backend.entities.MicroNutrientInfo;
import rezeptofant.backend.repositories.MicroNutrientInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MicroNutrientInfoService {

    private final MicroNutrientInfoRepository microNutrientInfoRepository;


    public List<MicroNutrientInfo> findAll() {

        Iterable<MicroNutrientInfo> all = microNutrientInfoRepository.findAll();

        List<MicroNutrientInfo> result = new ArrayList<>();
        for (MicroNutrientInfo info : all) {
            result.add(info);
        }

        return result;

    }

    @Nullable
    public MicroNutrientInfo findById(@Nonnull Long id) {
        Optional<MicroNutrientInfo> possibleMicroNutrientInfo = microNutrientInfoRepository.findById(id);
        return possibleMicroNutrientInfo.orElse(null);
    }

    public MicroNutrientInfo create(@Nonnull MicroNutrientInfo microNutrientInfo) {
        if (microNutrientInfo.getId() != null && findById(microNutrientInfo.getId()) != null) {
            return microNutrientInfo;
        }

        return microNutrientInfoRepository.save(microNutrientInfo);
    }

    @Nullable
    public MicroNutrientInfo update(@Nonnull MicroNutrientInfo microNutrientInfo) {
        if (microNutrientInfo.getId() == null) {
            return null;
        }

        MicroNutrientInfo dbObject = findById(microNutrientInfo.getId());
        if (dbObject == null) {
            return null;
        }

        microNutrientInfo.setId(dbObject.getId());
        return microNutrientInfoRepository.save(microNutrientInfo);
    }


    @Nullable
    public MicroNutrientInfo delete(@Nonnull Long id) {
        MicroNutrientInfo nutrientInfo = findById(id);
        if (nutrientInfo == null) {
            return null;
        }

        microNutrientInfoRepository.deleteById(id);
        return nutrientInfo;
    }


}
