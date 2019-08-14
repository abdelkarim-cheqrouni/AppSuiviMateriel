package com.controller;


import java.security.Principal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entites.Produit;
import com.repository.ProduitRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

 

@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ProduitController {
    @Autowired
    ProduitRepository produitRepository;
     
    @GetMapping("/hii")
    public String hi() {
        return "Hello world! >>> ";
      }
   
    
    
    
    
    
    
    
    
    
    
    
    
    /*@GetMapping("/produits")
    public  Page<Produit> chercher(
    		@RequestParam(name="mc", defaultValue = "") String mc,
    		@RequestParam(name="page", defaultValue = "0") int page,
    		@RequestParam(name="size", defaultValue = "5") int size
    		){
    	return produitRepository.chercher(mc, new PageRequest(page, size ));
    }*/
    
    @GetMapping("/produits")
    public List<Produit> getAllProduit() {
      System.out.println("Get all produits...");
   
      List<Produit> prods = new ArrayList<>();
      produitRepository.findAll().forEach(prods::add);
   
      return prods;
    }
    
    /*
    @GetMapping("/produits")
    public List<Produit> findAll(@RequestParam String equipement) {
   
      return produitRepository.findByEquipement(equipement);

    }*/
    
   
   
  /*  @PutMapping("/produits/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit p ) {
      System.out.println("update  produit...");
   
      List<Produit> prods = new ArrayList<>();
      produitRepository.findAll().forEach(prods::add);
   
      Produit pr = produitRepository.findById(id)
    		  .orElseThrow(() -> new ResourceNotFoundException());
     
      p.setEquipement(pr.getEquipement());
      p.setMarque(pr.getMarque());
      p.setType(pr.getType());

      p.setDate_garantie(pr.getDate_garantie());
      p.setDate_livraison(pr.getDate_livraison());
      
      return produitRepository.save(p);
    
    }*/
    
    
    
   /* @GetMapping(value = "produits/get/{id}")
    public ResponseEntity<List<Produit>> findById(@PathVariable int id) {
        System.out.println("find by id produit...");

      try {
        List<produit> pr = produitRepository.findById(id);
   
        if (pr.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pr, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
      }
    }*/
    
    
  /*
   *
   * 
    @PutMapping("/produits/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable("id") long id, @RequestBody Produit p) {
      java.util.Optional<Produit> prod = produitRepository.findById(id);
   
      if (prod.isPresent()) {
        Produit _p = prod.get();
        
        _p.setEquipement(p.getEquipement());
        _p.setMarque(p.getMarque());
        
        return new ResponseEntity<>(produitRepository.save(_p), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    *
    */
    
    
    
    
    
    /*@PutMapping("/produits/{id}")
    public Produit updateProduit(@PathVariable(value = "id") Long idproduit,
                                           @Valid @RequestBody Produit p) {

        Produit produit = produitRepository.findById(idproduit)
                .orElseThrow(() -> new ResourceNotFoundException("Produit", "id", idproduit));

        produit.setEquipement(p.getEquipement());
        produit.setMarque(p.getMarque());

        Produit updatedNote = produitRepository.save(produit);
        return updatedNote;
    }*/
    
    
   /* @DeleteMapping("/produits/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProduit(@PathVariable("id") long id) {
        System.out.println("delete produit...");

      try {
       produitRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
      }
    }
    */
    
    @DeleteMapping("/produits/delete/{id}")
    public boolean supprimer(@PathVariable("id") long id) {
        System.out.println("delete produit...");

      
       produitRepository.deleteById(id);
       
       return true;
    }
    
  /*  @GetMapping("/chercherProduit")
    public Page<Produit> chercher(
    		@RequestParam(name="mc" ,defaultValue ="") String mc,
    		@RequestParam(name="page" ,defaultValue ="0") int page, 
    		@RequestParam(name="size" ,defaultValue ="5") int size) {
    	return produitRepository.chercher(mc, new PageRequest(page, size, new Sort.by("equipement")));
    }*/
    

    /*
    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue ="0") int page) {
    	model.addAttribute("data", produitRepository.
    			findAll(new PageRequest(page, 4)));
    	
    	
		return "index";
    	
    }*/

    @PostMapping(value = "/produits")
    public ResponseEntity<Produit> postProduit(@RequestBody Produit prod) {      System.out.println("add produit..."  );
    

    	try {
        Produit _Produit = produitRepository.save(new Produit(prod.getEquipement(), prod.getMarque(), prod.getType(), prod.getDate_livraison(), prod.getDate_garantie()));
        return new ResponseEntity<>(_Produit, HttpStatus.CREATED);
        
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
      }
    	
    	
    }
    
    

  
    @RequestMapping("/saves")
    public String ss(){
        
      produitRepository.save(new Produit());
	return "done";
    }
    
    
    
    @DeleteMapping("/produits")
    public ResponseEntity<HttpStatus> deleteAllProduits() {
        System.out.println("delete all produits..(les produits supprimer : ) :");
        produitRepository.findAll().forEach(p ->{
          	System.out.println(p.getEquipement());
          	});

      try {
        produitRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
      }
   
    }
    
    

    
    
    /*
    @PutMapping("/Produits/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable int id,
         @Valid @RequestBody Produit ProduitDetails)  {
        List<Produit> pr = produitRepository.findById(id);

       ((Produit) pr).setEquipement(ProduitDetails.getEquipement());
        ((Produit) pr).setMarque(ProduitDetails.getMarque());
        ((Produit) pr).setType(ProduitDetails.getType());
        final Produit updatedProduit = produitRepository.save(pr);
        return ResponseEntity.ok(updatedProduit);
    }
    */
    
   /* @PutMapping("/Produits/{id}")
   
    public Produit updateProduit(@PathVariable("id") long id, @RequestBody @Valid Produit p) {
        System.out.println("update produit...");

        return produitRepository.save(p);
    }
    */
    /* @DeleteMapping("/produits/{id}")
    public ResponseEntity<HttpStatus> deleteProduit(@PathVariable("id") long id) {
      try {
        produitRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
      }
    }*/
    
    /* 
    
    
    @GetMappingtm("/api/hi")
    public String hi() {
      return "Hello world! >>> ";
    }
   
    
    
    
    @RequestMapping("/api/save")
    public String process(){
        produitRepository.save(new Produit("pc", "dell"));
        produitRepository.save(new Produit("pc", "hp"));
        produitRepository.save(new Produit("datashow", "dell"));
        produitRepository.save(new Produit("imprimante", "hp"));
        produitRepository.save(new Produit("imprimante", "dell"));
        return "Done";
    }
      
    @RequestMapping("/api/hi")
    public String hi() {
      return "Hello world! >>> ";
    }
   
    /*@DeleteMapping("/produits")
    public RepositoryProduit<HttpStatus> deleteAllProduits(){
    	try {
    		produitRepository.deleteAll();
    		return new RepositoryProduit<>(HttpStatus.NO_CONTENT);
    	}catch (Exception e) {
    		return new RepositoryProduit(HttpStatus.EXPECTATION_FAILED);
    	}
    }*/
    /*
    @GetMapping(value = "produits/id/{id}")
    public String findById(@PathVariable int id) {
		
    	try {
    		List<Produit> ps = produitRepository.findById(id);
    		if(ps.isEmpty()) {
    			return "pas de produis" + "<html>";
    		}
    		
    		return ps.toString();
    	}catch(Exception e ) {
    		return "error"+"<html>";
    	}
    	
    	
    	
    }
    
    
    
      
    @RequestMapping("/findall")
    public String findAll(){
        String result = "<html>";
          
        for(Produit P : produitRepository.findAll()){
            result += "<div>" + P.toString() + "</div>";
        }
          
        return result + "</html>";
    }
      
    
    @RequestMapping("/api/saves")
    public String ss(){
        
      produitRepository.save(new Produit());
	return "done";
    }
     
   /* @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }
      
    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "<html>";
          
        for(Produit cust: repository.findByLastName(lastName)){
            result += "<div>" + cust.toString() + "</div>"; 
        }
          
        return result + "</html>";
    }*/
}