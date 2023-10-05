package com.utn.apiresttutorial.repositories;

import com.utn.apiresttutorial.entities.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {
}
