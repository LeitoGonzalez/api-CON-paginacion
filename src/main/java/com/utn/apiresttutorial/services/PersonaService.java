package com.utn.apiresttutorial.services;

import com.utn.apiresttutorial.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long> {

    List<Persona> search(String nomyape) throws Exception;
    List<Persona> searchDni(String dni) throws Exception;


    Page<Persona> searchByNom(String nomyape, Pageable pageable) throws Exception;
    Page<Persona> searchBydni(String dni, Pageable pageable) throws Exception;

}
