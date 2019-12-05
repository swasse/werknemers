package be.ehb.werknemers.controllers;

import be.ehb.werknemers.model.Employee;
import be.ehb.werknemers.model.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeDAO dao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Employee> findAll(){
        return dao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Employee> findById(@PathVariable(value = "id") int id){
        return dao.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Iterable<Employee> findAllByName(@RequestParam(value = "name") String name){
        return dao.findAllByName(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addOne(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "phonennr") String phonenr,
                                 @RequestParam(value = "email") String email){
        Employee temp = new Employee();
        temp.setName(name);
        temp.setPhonenr(phonenr);
        temp.setEmail(email);
        dao.save(temp);

        return new ResponseEntity(HttpStatus.OK);
    }
}
