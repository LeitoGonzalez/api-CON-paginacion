package com.utn.apiresttutorial.repositories;

import com.utn.apiresttutorial.entities.Libro;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {

}
