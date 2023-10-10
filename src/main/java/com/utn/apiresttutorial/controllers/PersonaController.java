package com.utn.apiresttutorial.controllers;


import com.utn.apiresttutorial.entities.Persona;
import com.utn.apiresttutorial.services.PersonaService;
import com.utn.apiresttutorial.services.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")

public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String nom) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.search(nom));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \""+ e.getMessage() + "\"}");
        }
    }


    @GetMapping("/searchpage")
    public ResponseEntity<?> searchpage(@RequestParam String nom, Pageable pageable) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.searchByNom(nom, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \""+ e.getMessage() + "\"}");
        }
    }



    @GetMapping("/searchdni")
    public ResponseEntity<?> searchdni(@RequestParam String dni) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.searchDni(dni));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \""+ e.getMessage() + "\"}");
        }
    }



}
