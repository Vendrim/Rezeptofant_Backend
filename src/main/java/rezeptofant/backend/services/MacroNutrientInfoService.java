package rezeptofant.backend.services;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rezeptofant.backend.entities.MacroNutrientInfo;
import rezeptofant.backend.repositories.MacroNutrientInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MacroNutrientInfoService {

    private final MacroNutrientInfoRepository macroNutrientInfoRepository;

    public List<MacroNutrientInfo> findAll() {
        Iterable<MacroNutrientInfo> all = macroNutrientInfoRepository.findAll();
        List<MacroNutrientInfo> result = new ArrayList<>();

        for (MacroNutrientInfo macNutInfo : all) {
            result.add(macNutInfo);
        }
        return result;
    }

    @Nullable
    public MacroNutrientInfo findById(Long id) {
        Optional<MacroNutrientInfo> possibleMacro = macroNutrientInfoRepository.findById(id);
        return possibleMacro.orElse(null);
    }

    public MacroNutrientInfo create(MacroNutrientInfo macroNutrientInfo) {
        if (macroNutrientInfo.getId() == null || findById(macroNutrientInfo.getId()) == null) {
            return macroNutrientInfoRepository.save(macroNutrientInfo);
        }
        return macroNutrientInfo;
    }

    @Nullable
    public MacroNutrientInfo update(MacroNutrientInfo macroNutrientInfo) {
        if (macroNutrientInfo == null || macroNutrientInfo.getId() == null || findById(macroNutrientInfo.getId()) == null) {
            return null;
        }

        return macroNutrientInfoRepository.save(macroNutrientInfo);
    }

    @Nullable
    public MacroNutrientInfo delete(Long id) {
        if (id == null) {
            return null;
        }

        MacroNutrientInfo macroNutrientInfo = findById(id);
        if (macroNutrientInfo == null) {
            return null;
        }


        macroNutrientInfoRepository.deleteById(id);
        return macroNutrientInfo;
    }


}
