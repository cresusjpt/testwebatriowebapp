package com.saltech.testwebatriowebapp.service;

import com.saltech.testwebatriowebapp.models.Personne;
import com.saltech.testwebatriowebapp.repos.EmployeCallApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PersonneService {

    @Autowired
    private EmployeCallApi employeCallApi;

    public Iterable<Personne> getPersonnes() {
        Iterable<Personne> lisPersonnes = employeCallApi.getPersonnes();

        for (Personne element : lisPersonnes) {
            element.setAge(element.calculateAge(LocalDate.now()));

        }
        return lisPersonnes;
    }

    public Personne savePersonne(Personne personne) throws Exception {
        Personne savedPersonne;

        if (personne.calculateAge(LocalDate.now()) <150 ){
            if(personne.getId() == null) {
                //create if not exist
                savedPersonne = employeCallApi.savePersonne(personne);
            } else {
                //not handle the update
                savedPersonne = employeCallApi.updatePersonne(personne);
            }
        }else{
            throw new Exception("La personne à plus de 150 ans");
        }
        return savedPersonne;
    }
}
