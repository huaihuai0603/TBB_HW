package com.example.api_hw;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

//這個是用來統整EntityModel的程式，因為剛剛要幫每個employee做還要對整個集體employees做
//這邊一次幫大家用好好
@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee,EntityModel<Employee>> {
    
    @Override
    //toModel是將非model的東西轉變成model
    public EntityModel<Employee> toModel(Employee employee) {

        return EntityModel.of(employee, //
            linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
            linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }
}
