package com.udacity.dog_graphql.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.dog_graphql.entity.Dog;
import com.udacity.dog_graphql.exception.DogNotFoundException;
import com.udacity.dog_graphql.repository.DogRepository;

import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver{
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> optionalDogInfo = dogRepository.findById(id);
        if(optionalDogInfo.isPresent()){
            return optionalDogInfo.get();
        }
        else{
            throw new DogNotFoundException("Dog Not Found",id);
        }
    }
}
