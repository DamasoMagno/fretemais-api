package com.fretemais.api.controller;

import com.fretemais.api.domain.Transporter;
import com.fretemais.api.dto.TransporterDTO;
import com.fretemais.api.services.TransporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transporter")
public class TransportController {

    @Autowired
    private TransporterService transporterService;

    @GetMapping()
    public ResponseEntity<List<Transporter>> transports(@RequestParam(required = false) String name) {
        return ResponseEntity.status(HttpStatus.OK).body(transporterService.listTransporters(name));
    }

    @PostMapping()
    public ResponseEntity<?> createTransporter(@RequestBody Transporter transporter) {
        transporterService.createTransporter(transporter);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/{transporterId}")
    public ResponseEntity<?> deleteFreight(@PathVariable Long transporterId) {
        transporterService.deleteTransporter(transporterId);
       return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/{transporterId}")
     public ResponseEntity<?> getFreight(@PathVariable Long transporterId) {
        return ResponseEntity.status(HttpStatus.OK).body(transporterService.getTransporter(transporterId));
     }

    @PutMapping("/{transporterId}")
    public ResponseEntity<Void> updateTransporter(
            @PathVariable Long transporterId,
            @RequestBody TransporterDTO transporter
    ) {
        System.out.println(transporter);

        transporterService.updateTransporter(transporterId, transporter);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
