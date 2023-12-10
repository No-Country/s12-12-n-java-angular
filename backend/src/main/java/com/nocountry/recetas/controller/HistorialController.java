package com.nocountry.recetas.controller;


import com.nocountry.recetas.domain.response.HistorialResponse;
import com.nocountry.recetas.service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/historial")
public class HistorialController {
    @Autowired
    private HistorialService historialService;

    @GetMapping("/get-historial")
    public ResponseEntity<List<HistorialResponse>> getHistorial(){
        return ResponseEntity.ok().body(historialService.getHistorial());
    }


}
