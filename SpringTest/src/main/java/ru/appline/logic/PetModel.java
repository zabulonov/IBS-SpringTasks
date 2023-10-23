package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PetModel implements Serializable {

    private static final PetModel instance = new PetModel();

    private final Map<Integer, Pet> model;

    public PetModel()
    {
        model = new HashMap<Integer, Pet>();
        model.put(1, new Pet("Sharik", "Dog", 3));
        model.put(2, new Pet("Shrek", "Ogre", 40));
        model.put(3, new Pet("Mysia", "Cat", 4));
    }

    public static PetModel getInstance()
    {
        return instance;
    }

    public void Add(Pet pet, int id) { model.put(id, pet); }
    public Pet getFromList(int id) { return model.get(id); }
    public Map<Integer, Pet> getAll() {return model;}
    public void Delete(Pet pet, int id) { model.remove(id, pet); }
    public void Edit(Pet pet, int id) {model.replace(id, pet);}
}
