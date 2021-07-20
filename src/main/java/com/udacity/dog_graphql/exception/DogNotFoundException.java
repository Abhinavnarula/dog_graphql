package com.udacity.dog_graphql.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class DogNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String,Object> exceptions = new HashMap<>();

    public DogNotFoundException(String message, Object invalidDogId) {
        super(message);
        exceptions.put("invalidDogId", invalidDogId);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return exceptions;
    }
    
}
