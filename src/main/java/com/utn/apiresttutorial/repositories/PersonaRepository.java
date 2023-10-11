package com.utn.apiresttutorial.repositories;

import com.utn.apiresttutorial.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {


    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    List<Persona> findByDni(String dni);




    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1% ")
    List<Persona> search(@Param ("filtro") String filtro);

    @Query(value = "SELECT p FROM Persona p WHERE p.dni LIKE %:filtro%")
    List<Persona> searchDni(@Param ("filtro") String filtro);




    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%' ",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);




//Pageable

    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    List<Persona> findByDni(String dni, Pageable pageable);




    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro% ")
    Page<Persona> searchPaged(@Param ("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT p FROM Persona p WHERE p.dni LIKE %:filtro%")
    Page<Persona> searchDniPaged(@Param ("filtro") String filtro, Pageable pageable);




    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%' ",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
