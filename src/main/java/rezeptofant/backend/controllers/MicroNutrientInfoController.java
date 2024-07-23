package rezeptofant.backend.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rezeptofant.backend.entities.MicroNutrientInfo;
import rezeptofant.backend.services.MicroNutrientInfoService;
import rezeptofant.backend.util.Endpoints;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MicroNutrientInfoController {

    private final MicroNutrientInfoService microNutrientInfoService;

    @GetMapping(Endpoints.MICRO + Endpoints.GET_ALL)
    public List<MicroNutrientInfo> getAll() {
        return microNutrientInfoService.findAll();
    }

    @GetMapping(Endpoints.MICRO + Endpoints.GET + "/{id}")
    public MicroNutrientInfo get(@PathVariable("id") Long id) {
        return microNutrientInfoService.findById(id);
    }

    @PostMapping(Endpoints.MICRO + Endpoints.CREATE)
    public MicroNutrientInfo create(MicroNutrientInfo microNutrientInfo) {
        return microNutrientInfoService.create(microNutrientInfo);
    }

    @PutMapping(Endpoints.MICRO + Endpoints.UPDATE)
    public MicroNutrientInfo update(MicroNutrientInfo microNutrientInfo) {
        if (microNutrientInfo.getId() == null) {
            return null;
        }

        return microNutrientInfoService.update(microNutrientInfo);
    }

    @DeleteMapping(Endpoints.MICRO + Endpoints.DELETE + "/{id}")
    public MicroNutrientInfo delete(@PathVariable("id") Long id) {
        if (id == null || id < 1 || id == Integer.MAX_VALUE || id == Integer.MIN_VALUE) {
            return null;
        }

        return microNutrientInfoService.delete(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
    }
}
