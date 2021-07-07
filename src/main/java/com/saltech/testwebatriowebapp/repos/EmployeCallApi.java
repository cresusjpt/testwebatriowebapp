package com.saltech.testwebatriowebapp.repos;

import com.saltech.testwebatriowebapp.config.CProperties;
import com.saltech.testwebatriowebapp.models.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmployeCallApi {

    @Autowired
    private CProperties properties;


    public Iterable<Personne> getPersonnes() {
        String baseApiUrl = properties.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/personnes";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Personne>> responseEntity = restTemplate.exchange(
                getEmployeesUrl, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Personne>>() {
                }
        );

        return responseEntity.getBody();
    }

    public Personne savePersonne(Personne personne){
        String baseApiUrl = properties.getApiUrl();
        String createEmployeeUrl = baseApiUrl + "/savePersonne";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Personne> request = new HttpEntity<>(personne);
        ResponseEntity<Personne> response = restTemplate.exchange(
                createEmployeeUrl,
                HttpMethod.POST,
                request,
                Personne.class
        );

        return response.getBody();
    }

    public Personne updatePersonne(Personne personne){
        String baseApiUrl = properties.getApiUrl();
        String updateEmployeeUrl = baseApiUrl + "/personne/"+personne.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Personne> request = new HttpEntity<>(personne);
        ResponseEntity<Personne> responseEntity = restTemplate.exchange(
                updateEmployeeUrl,
                HttpMethod.PUT,
                request,
                Personne.class
        );

        return responseEntity.getBody();
    }
}
