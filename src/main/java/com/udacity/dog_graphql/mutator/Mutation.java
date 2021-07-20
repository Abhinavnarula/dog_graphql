package com.udacity.dog_graphql.mutator;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.dog_graphql.entity.Dog;
import com.udacity.dog_graphql.exception.BreedNotFoundException;
import com.udacity.dog_graphql.exception.DogNotFoundException;
import com.udacity.dog_graphql.repository.DogRepository;

import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        Iterable<Dog> allDogs = dogRepository.findAll();
        for (Dog d : allDogs) {
            if(d.getBreed().equals(breed)){
                dogRepository.delete(d);
                return true;
            }
        }
        throw new BreedNotFoundException("Breed Not Found", breed);
    }

    public Dog updateDogName(Long id, String newName) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        }
        else{
            throw new DogNotFoundException("Dog not found", id);
        }
    }

}
