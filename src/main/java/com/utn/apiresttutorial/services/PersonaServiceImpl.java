package com.utn.apiresttutorial.services;

import com.utn.apiresttutorial.entities.Persona;
import com.utn.apiresttutorial.repositories.BaseRepository;
import com.utn.apiresttutorial.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
            List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}