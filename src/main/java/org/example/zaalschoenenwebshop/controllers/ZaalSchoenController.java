package org.example.zaalschoenenwebshop.controllers;


import org.example.zaalschoenenwebshop.dao.ZaalSchoenDAO;
import org.example.zaalschoenenwebshop.dto.ZaalSchoenDTO;
import org.example.zaalschoenenwebshop.models.ZaalSchoen;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zaalschoenen")
public class ZaalSchoenController {

    private ZaalSchoenDAO zaalSchoenDAO;

    public ZaalSchoenController(ZaalSchoenDAO zaalSchoenDAO) {
        this.zaalSchoenDAO = zaalSchoenDAO;
    }

    @GetMapping
    public ResponseEntity<List<ZaalSchoen>> getAllZaalSchoenen(){

        return ResponseEntity.ok(this.zaalSchoenDAO.getAllZaalSchoenen());
    }

    @PostMapping
    public ResponseEntity<String> createZaalSchoen(@RequestBody ZaalSchoenDTO zaalSchoenDTO){
        this.zaalSchoenDAO.createZaalschoen(zaalSchoenDTO);
        return ResponseEntity.ok("Created a Schoen");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateZaalSchoen(@PathVariable Long id, @RequestBody ZaalSchoenDTO zaalSchoenDTO){
        this.zaalSchoenDAO.updateZaalschoen(zaalSchoenDTO, id);

        return ResponseEntity.ok("Updated Schoen with id" + id);
    }

    //@PutMapping("check/{id}")
    //public ResponseEntity<String> checkZaalSchoen(@PathVariable Long id){
      //  this.zaalSchoenDAO.checkZaalSchoen(id);

        //return ResponseEntity.ok("Schoen checked with id " + id);
    //}

    //@PutMapping("uncheck/{id}")
    //public ResponseEntity<String> uncheckZaalSchoen(@PathVariable Long id){
      //  this.zaalSchoenDAO.uncheckZaalSchoen(id);

        //return ResponseEntity.ok("Schoen uncheck with id " + id);
    //}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        this.zaalSchoenDAO.deleteById(id);

        return ResponseEntity.ok("Schoen deleted with id " + id);
    }
}
