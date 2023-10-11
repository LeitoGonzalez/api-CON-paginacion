package com.utn.apiresttutorial.services;

import com.utn.apiresttutorial.entities.Persona;
import com.utn.apiresttutorial.repositories.BaseRepository;
import com.utn.apiresttutorial.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements PersonaService{

    @Autowired
    protected PersonaRepository personaRepository;

    public PersonaServiceImpl (BaseRepository<Persona,Long> baseRepository, PersonaRepository personaRepository){
        super(baseRepository);
        this.personaRepository=personaRepository;
    }




    @Override
    public List<Persona> search(String filtro) throws Exception {
        try{
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            List<Persona> personas = personaRepository.search(filtro);
            //List<Persona> personas = personaRepository.searchNativo(filtro);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> searchDni(String dni) throws Exception {
        try {
            //List<Persona> personas = personaRepository.findByDni(dni);
            List<Persona> personas = personaRepository.searchDni(dni);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }





    @Override
    public Page<Persona> searchPaged(String nomyape, Pageable pageable) throws Exception {
        try{
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(nomyape, nomyape, pageable);
            Page<Persona> personas = personaRepository.searchPaged(nomyape, pageable);
            //Page<Persona> personas = personaRepository.searchNativo(nomyape, pageable);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> searchDniPaged(String dni, Pageable pageable) throws Exception {
        try {
            //Page<Persona> personas = personaRepository.findByDni(dni, pageable);
            Page<Persona> personas = personaRepository.searchDniPaged(dni, pageable);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}