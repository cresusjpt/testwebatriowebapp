package com.saltech.testwebatriowebapp.service;

import com.saltech.testwebatriowebapp.models.Personne;
import com.saltech.testwebatriowebapp.repos.EmployeCallApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {

    @Autowired
    private EmployeCallApi employeCallApi;

    public Iterable<Personne> getPersonnes() {
        return employeCallApi.getPersonnes();
    }

    public Personne savePersonne(Personne personne) {
        Personne savedPersonne;

        if(personne.getId() == null) {
            //create if not exist
            savedPersonne = employeCallApi.savePersonne(personne);
        } else {
            //not handle the update
            savedPersonne = employeCallApi.updatePersonne(personne);
        }

        return savedPersonne;
    }
}
