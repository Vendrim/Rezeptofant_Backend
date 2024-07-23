package rezeptofant.backend.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rezeptofant.backend.entities.NutrientExtraInfo;
import rezeptofant.backend.services.NutrientExtraInfoService;
import rezeptofant.backend.util.Endpoints;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class NutrientExtraInfoController {

    private final NutrientExtraInfoService nutrientExtraInfoService;

    @GetMapping(Endpoints.NUTRIENT_EXTRA + Endpoints.GET_ALL)
    public List<NutrientExtraInfo> getAll() {
        return nutrientExtraInfoService.findAll();
    }

    @GetMapping(Endpoints.NUTRIENT_EXTRA + Endpoints.GET + "/{id}")
    public NutrientExtraInfo get(@PathVariable("id") Long id) {
        return nutrientExtraInfoService.findById(id);
    }

    @PostMapping(Endpoints.NUTRIENT_EXTRA + Endpoints.CREATE)
    public NutrientExtraInfo create(NutrientExtraInfo nutrientExtraInfo) {
        return nutrientExtraInfoService.create(nutrientExtraInfo);
    }

    @PutMapping(Endpoints.NUTRIENT_EXTRA + Endpoints.UPDATE)
    public NutrientExtraInfo update(NutrientExtraInfo nutrientExtraInfo) {
        if (nutrientExtraInfo.getId() == null) {
            return null;
        }

        return nutrientExtraInfoService.update(nutrientExtraInfo);
    }

    @DeleteMapping(Endpoints.NUTRIENT_EXTRA + Endpoints.DELETE + "/{id}")
    public NutrientExtraInfo delete(@PathVariable("id") Long id) {
        if (id == null || id < 1 || id == Integer.MAX_VALUE || id == Integer.MIN_VALUE) {
            return null;
        }

        return nutrientExtraInfoService.delete(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
    }
}
