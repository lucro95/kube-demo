package com.example.minikube.demo.kubedemo; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class KubeController {

    private HashMap<Long,Kube> repository  = new HashMap<Long,Kube>();
    private long localId = 0l;

    @GetMapping
    public ResponseEntity index(){
        return new ResponseEntity(repository.values(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable Long id){
        return new ResponseEntity(repository.get(id),HttpStatus.OK);
    }

    @PostMapping
    public String create(@RequestBody Kube kube){
        kube.setId(++localId);
        repository.put(kube.getId(),kube);
        return "Kube "+kube+" Created";
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody Kube kube, @PathVariable Long id){
        if(repository.containsKey(id)){
            kube.setId(id);
            repository.replace(id,kube);
        }

        return new ResponseEntity(kube,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public String remove(@PathVariable Long id){
        repository.remove(id);
        return "Kube having ID = "+id+ " is removed";
    }
}