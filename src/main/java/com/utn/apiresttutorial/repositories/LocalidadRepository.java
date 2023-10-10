package com.utn.apiresttutorial.repositories;

import com.utn.apiresttutorial.entities.Localidad;
import com.utn.apiresttutorial.entities.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long> {
}
