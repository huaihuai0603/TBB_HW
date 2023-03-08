package com.example.api_hw;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import org.springframework.hateoas.*;
//onmethod用這個
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class EmployeeController {
    private final EmployeeRepository repository;
    //這邊引入幫忙節省設定EntityModel時間的方法-"assembler"
    private final EmployeeModelAssembler assembler;

    EmployeeController(EmployeeRepository repository,EmployeeModelAssembler assembler) {
      this.repository = repository;
      this.assembler  = assembler;
    }
  
    // // 這邊是第一代的GetMapping(整個employee)
    // Aggregate root
    // tag::get-aggregate-root[]
    // @GetMapping("/employees")
    // List<Employee> all() {
    //   return repository.findAll();
    // }
    // end::get-aggregate-root[]

    // //這邊是第二代的GetMapping(整個employee)
    // @GetMapping("/employees")
    // //CollectionModel是用來封裝多個Entity的，因為這個是要對所有資料
    // //CollectionModel也是一個不止包含資料還包含連結的container
    // CollectionModel<EntityModel<Employee>> all() {
    //   List<EntityModel<Employee>> employees = repository
    //   .findAll().stream().map(employee -> EntityModel.of(employee,
    //   //加入的這些link都會顯示在_embedded下面，每個employee也都會有自己的連結與資料
    //       linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
    //       linkTo(methodOn(EmployeeController.class).all()).withRel("employees")))
    //       .collect(Collectors.toList());
    //   return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    // }
      
    // //這邊是第三代的GetMapping(整個employee)，運用RepresentationModel簡化過程
    @GetMapping("/employees")
    CollectionModel<EntityModel<Employee>> all() {
      List<EntityModel<Employee>> employees = repository.findAll().stream() //
      .map(assembler::toModel) //
      .collect(Collectors.toList());

    return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }
    //舊的方法
    // @PostMapping("/employees")
    // Employee newEmployee(@RequestBody Employee newEmployee) {
    //   return repository.save(newEmployee);
    // }

    @PostMapping("/employees")
    ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {

      EntityModel<Employee> entityModel = assembler.toModel(repository.save(newEmployee));

      return ResponseEntity //
      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
      .body(entityModel);
    }

    // Single item
    
    // // 這個是第一代的GetMapping(個別employee)
    // @GetMapping("/employees/{id}")
    // Employee one(@PathVariable Long id) {
    //   return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    // }

    // //這個是第二代的GetMapping(個別employee)
    // @GetMapping("/employees/{id}")
    // //EntityModel是一個不止包含資料還包含連結的container
    // //所以若資料要顯示連結就不用Employee
    // EntityModel<Employee> one(@PathVariable Long id) {
    //   //將要回傳的東西宣告成employee，這樣方便後面return employee就好
    //   Employee employee = repository.findById(id) //
    //   .orElseThrow(() -> new EmployeeNotFoundException(id));
    //   //這邊就會回傳東西，
    //   return EntityModel.of(employee, //
    //   //讓Spring HATEOAS建立一個對該id的連結，並設成self link
    //   linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
    //   //讓Spring HATEOAS建立一個對整體的連結，並叫做employees
    //   linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    // }

    // //這個是第三代的GetMapping(個別employee)，運用RepresentationModel簡化過程
    @GetMapping("/employees/{id}")
    EntityModel<Employee> one(@PathVariable Long id){
      Employee employee = repository.findById(id) //
      .orElseThrow(() -> new EmployeeNotFoundException(id));
      return assembler.toModel(employee);
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
      
      return repository.findById(id)
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setRole(newEmployee.getRole());
          return repository.save(employee);
        })
        .orElseGet(() -> {
          newEmployee.setId(id);
          return repository.save(newEmployee);
        });
    }
  
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
      repository.deleteById(id);
    }
}
