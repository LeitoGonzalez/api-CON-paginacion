package com.utn.apiresttutorial.controllers;


import com.utn.apiresttutorial.entities.Persona;
import com.utn.apiresttutorial.services.PersonaService;
import com.utn.apiresttutorial.services.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {
}
