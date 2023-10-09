package com.utn.apiresttutorial.repositories;

import com.utn.apiresttutorial.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {

    //anotacion query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //boolean existByDni(String dni);


        //anotacion jpql parametros indexados

        //busca personas con 2 nombres, si queremos q busque solo por un nombre le cambiamos el ?2 por un ?1 y sacamos el filtro2
    //@Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?2%' ")
    //List<Persona> search(String filtro, String filtro2);


        //anotacion jpql parametros nombrados

        //aca busca por nombre o apellido
    //@Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%' ")
    //List<Persona> search(@Param("filtro") String filtro);


        //anotacion query nativo

    //@Query(
            //value = "SELECT * FROM persona WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%' ",
            //nativeQuery = true
    //)
    //List<Persona> search1(String filtro);
}
