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
    public List<Persona> search(String nomyape) throws Exception {
        try{
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(nomyape, nomyape);
            //List<Persona> personas = personaRepository.search(nomyape);
            List<Persona> personas = personaRepository.searchNativo(nomyape);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> searchDni(String dni) throws Exception {
        try {
            List<Persona> personas = personaRepository.findByDni(dni);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }





    @Override
    public Page<Persona> searchByNom(String nomyape, Pageable pageable) throws Exception {
        try{
            //Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(nomyape, nomyape, pageable);
            //Page<Persona> personas = personaRepository.search(nomyape, pageable);
            Page<Persona> personas = personaRepository.searchNativo(nomyape, pageable);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> searchBydni(String dni, Pageable pageable) throws Exception {
        try {
            Page<Persona> personas = personaRepository.findByDni(dni, pageable);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}