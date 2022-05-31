package com.ecommerce.backendapi.exception;
/*
This exception class will be called when a user tries to retrieve a product with an ID that does not exist
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public String resourceName;
    public String fieldName;
    public long fieldValue;

    // Parameterized constructor
    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue){
        super(String.format("%s with %s Not Found: '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }

}
