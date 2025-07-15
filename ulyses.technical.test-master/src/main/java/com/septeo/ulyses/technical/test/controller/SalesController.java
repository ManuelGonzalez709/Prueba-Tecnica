package com.septeo.ulyses.technical.test.controller;

import com.septeo.ulyses.technical.test.entity.Sales;
import com.septeo.ulyses.technical.test.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping
    public ResponseEntity<List<Sales>> getAllSales(@RequestParam(defaultValue = "0") Long page) {
        return ResponseEntity.ok(salesService.getAllSales(page));
    }



    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSalesById(@PathVariable Long id) {
        return salesService.getSalesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // TODO: implement here your endpoints

    @GetMapping("/brands/{bradId}")
    public ResponseEntity<List<Sales>> getSalesByBrandId(@PathVariable Long bradId) {
        return ResponseEntity.ok(salesService.getSalesByBrandId(bradId));
    }

    @GetMapping("/vehicles/{vehicleId}")
    public ResponseEntity<List<Sales>> getSalesByVehicleId(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(salesService.getSalesByVehicleId(vehicleId));
    }


}
