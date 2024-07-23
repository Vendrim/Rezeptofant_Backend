package rezeptofant.backend.services;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rezeptofant.backend.entities.VitaminInfo;
import rezeptofant.backend.repositories.VitaminInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VitaminInfoService {

    private final VitaminInfoRepository vitaminInfoRepository;


    public List<VitaminInfo> findAll() {
        List<VitaminInfo> result = new ArrayList<>();

        for (VitaminInfo info : vitaminInfoRepository.findAll()) {
            result.add(info);
        }

        return result;
    }

    @Nullable
    public VitaminInfo findById(@Nonnull Long id) {
        Optional<VitaminInfo> possibleVitaminInfo = vitaminInfoRepository.findById(id);
        return possibleVitaminInfo.orElse(null);
    }

    public VitaminInfo create(@Nonnull VitaminInfo vitaminInfo) {
        if (vitaminInfo.getId() != null && findById(vitaminInfo.getId()) != null) {
            return vitaminInfo;
        }

        return vitaminInfoRepository.save(vitaminInfo);
    }

    @Nullable
    public VitaminInfo update(@Nonnull VitaminInfo vitaminInfo) {
        if (vitaminInfo.getId() == null || findById(vitaminInfo.getId()) == null) {
            return null;
        }

        return vitaminInfoRepository.save(vitaminInfo);
    }

    @Nullable
    public VitaminInfo delete(@Nonnull Long id) {
        VitaminInfo vitaminInfo = findById(id);
        if (vitaminInfo == null) {
            return null;
        }

        vitaminInfoRepository.deleteById(id);

        return vitaminInfo;
    }


}
