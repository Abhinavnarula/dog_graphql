package com.udacity.dog_graphql.repository;

import com.udacity.dog_graphql.entity.Dog;

import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
    
}
