package org.Spring.aout.MySpring;

import org.Spring.aout.MySpring.entities.Produit;
import org.Spring.aout.MySpring.repositoty.ProduitRepository;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Ma propre Api rest personnalisé, on peut accéder à la couche metier et service

@RestController
public class ProduitRestService {

    @Autowired
    private ProduitRepository produitRepository;


    @GetMapping(value="/listProduits")
    public List<Produit> listProduits(){
        return produitRepository.findAll();

    }

    @GetMapping(value="/listProduits/{id}")
    public Produit produitById(@PathVariable(name="id") Long id){
        return produitRepository.findById(id).get();
    }

    @PutMapping(value="/listProduits/{id}")
    public Produit update(@PathVariable(name="id") Long id , @RequestBody Produit p){
        p.setId(id);
        return produitRepository.save(p);
    }


    @PostMapping(value="/listProduits/")
    public Produit save(@RequestBody Produit p){
        return produitRepository.save(p);
    }

    @DeleteMapping(value="/listProduits/{id}")
    public void delete(@PathVariable(name="id") Long id){
        produitRepository.deleteById(id);
    }


}
