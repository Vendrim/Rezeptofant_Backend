package rezeptofant.backend.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rezeptofant.backend.entities.MacroNutrientInfo;
import rezeptofant.backend.services.MacroNutrientInfoService;
import rezeptofant.backend.util.Endpoints;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MacroNutrientInfoController {

    private final MacroNutrientInfoService macroNutrientInfoService;

    @GetMapping(Endpoints.MACRO + Endpoints.GET_ALL)
    public List<MacroNutrientInfo> getAll() {
        return macroNutrientInfoService.findAll();
    }

    @GetMapping(Endpoints.MACRO + Endpoints.GET + "/{id}")
    public MacroNutrientInfo get(@PathVariable("id") Long id) {
        return macroNutrientInfoService.findById(id);
    }

    @PostMapping(Endpoints.MACRO + Endpoints.CREATE)
    public MacroNutrientInfo create(MacroNutrientInfo macroNutrientInfo) {
        return macroNutrientInfoService.create(macroNutrientInfo);
    }

    @PutMapping(Endpoints.MACRO + Endpoints.UPDATE)
    public MacroNutrientInfo update(MacroNutrientInfo macroNutrientInfo) {
        if (macroNutrientInfo.getId() == null) {
            return null;
        }

        return macroNutrientInfoService.update(macroNutrientInfo);
    }

    @DeleteMapping(Endpoints.MACRO + Endpoints.DELETE + "/{id}")
    public MacroNutrientInfo delete(@PathVariable("id") Long id) {
        if (id == null || id < 1 || id == Integer.MAX_VALUE || id == Integer.MIN_VALUE) {
            return null;
        }

        return macroNutrientInfoService.delete(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
    }
}
