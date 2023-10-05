package com.utn.apiresttutorial.repositories;

import com.utn.apiresttutorial.entities.Autor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends BaseRepository<Autor, Long> {
}
