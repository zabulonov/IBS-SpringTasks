package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {

    private static PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newid = new AtomicInteger(4);

    @PostMapping(value = "/createPet", consumes = "application/json")
    public String createPet(@RequestBody Pet pet)
    {
        petModel.Add(pet, newid.getAndIncrement());
        return "Successfully creating a pet - " + pet.getName();
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll(){
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id)
    {
        return petModel.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json", produces = "application/json")
    public String deletePet(@RequestBody Map<String, Integer> id)
    {
        Pet pet = petModel.getFromList(id.get("id"));
        petModel.Delete(pet, id.get("id"));
        return "Pet with name "+ pet.getName()+ " was deleted!" ;
    }

    @PutMapping(value = "/editPet", consumes = "application/json" , produces = "application/json")
    public Pet editPet(@RequestBody Map<String, String> json)
    {
        int id = Integer.parseInt(json.get("id"));
        String name = json.get("name");
        String type = json.get("type");
        int age = Integer.parseInt(json.get("age"));
        Pet editPet = new Pet(name, type, age);
        petModel.Edit(editPet, id);
        return editPet;
    }

}
