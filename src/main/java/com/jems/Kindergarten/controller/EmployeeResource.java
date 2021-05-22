package com.jems.Kindergarten.controller;

import com.jems.Kindergarten.model.Kid;
import com.jems.Kindergarten.services.KidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kids")
public class EmployeeResource {

    private final KidService kidService;

    public EmployeeResource(KidService kidService) {
        this.kidService = kidService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Kid>> getAllEmployees() {
        List<Kid> employees = kidService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Kid> addEmployee(@RequestBody Kid employee) {
        Kid employees = kidService.addKid(employee);
        return new ResponseEntity<>(employees, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Kid> updateEmployee(@RequestBody Kid employee) {
        Kid employees = kidService.update(employee);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        kidService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
