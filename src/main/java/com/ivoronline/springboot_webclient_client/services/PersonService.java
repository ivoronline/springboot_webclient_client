package com.ivoronline.springboot_webclient_client.services;

import com.ivoronline.springboot_webclient_client.entities.Person;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;

@Component
public class PersonService {

  //===============================================================
  // GET TEXT
  //===============================================================
  public void getText() {

    //CREATE STREAM
    String string = WebClient
      .create("http://localhost:8080")
      .get()
      .uri("/GetText")
      .retrieve()
      .bodyToMono(String.class)
      .block(Duration.ofSeconds(3));

    //DISPLAY STRING
    System.out.println("GetText()");
    System.out.println(string);

  }

  //===============================================================
  // GET PERSON
  //===============================================================
  public void getPerson() {

    //CREATE STREAM
    Person person = WebClient
      .create("http://localhost:8080")
      .get()
      .uri("/GetPerson")
      .retrieve()
      .bodyToMono(Person.class)
      .block(Duration.ofSeconds(3));

    //DISPLAY PERSON
    System.out.println("getPerson()");
    System.out.println(person.id + " " + person.name+ " " + person.age);

  }

  //===============================================================
  // GET PERSONS
  //===============================================================
  public void getPersons() {

    //GET PERSON FROM SERVER
    Person[] persons = WebClient
      .create("http://localhost:8080")
      .get()
      .uri("/GetPersons")
      .retrieve()
      .bodyToMono(Person[].class)
      .block(Duration.ofSeconds(3));

    //DISPLAY PERSONS
    System.out.println("getPersons()");
    for (Person person : persons) {
      System.out.println(person.id + " " + person.name+ " " + person.age);
    }

  }

}


