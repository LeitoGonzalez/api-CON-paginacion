package com.utn.apiresttutorial.controllers;

import com.utn.apiresttutorial.entities.Localidad;
import com.utn.apiresttutorial.services.LocalidadServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/localidades")

public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl> {
}
