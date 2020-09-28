package org.projet.jee.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.projet.jee.model.Employe;
import org.projet.jee.model.Employe_societe;
import org.projet.jee.model.Societe;
import org.projet.jee.repository.EmployeRepository;
import org.projet.jee.repository.Employe_societeRepository;
import org.projet.jee.repository.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SocieteController {

	@Autowired
	private SocieteRepository societeRepository;
	
	@Autowired
	private Employe_societeRepository societeEmployeRepository;
	
	@Autowired
	private EmployeRepository employeRepository;
	
	@PostMapping("/addSociete")
	public String saveSociete(@RequestBody Societe societe) {
	    societeRepository.save(societe);
	    return "added Societe whith id :" + societe.getId();
	}
	
	@PutMapping("/editsociete/{id}")
	public ResponseEntity<Object> EditSociete(@PathVariable int id ,@RequestBody Societe societe) {
		Optional<Societe> emp = societeRepository.findById(id);
		if (!emp.isPresent())
			return ResponseEntity.notFound().build();
		
		societe.setId(id);
		
		societeRepository.save(societe);

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/findAllSociete")
	public Iterable<Societe> getSociete(){
		return societeRepository.findAll();
	}
	
	@GetMapping("/findAllSociete/{id}")
	public Optional<Societe> getSociete(@PathVariable int id){
		return societeRepository.findById(id);
	}
	
	@DeleteMapping("/deleteSociete/{id}")
	public String deleteSociete(@PathVariable int id) {
		societeRepository.deleteById(id);
		return "supprimer avec succes";
	}
	
	 @GetMapping("/searchSocByName/{key}")
	    public List<Societe> getSocieteByName(@PathVariable("key") String key){
	        List<Societe> societes = new ArrayList<>();

	        societes  = societeRepository.findByNomContains(key+"");

	        return societes;
	    }
	 
	 
	 @GetMapping(path = "/deleteSociete/{idSoc}")
	    public void deleSociete(@PathVariable("idSoc") Integer idSoc){
	        int id = Integer.valueOf(idSoc);
	        Societe soc = societeRepository.findById(id).get();
	        List<Employe_societe> sc = new ArrayList<>() ;
	        sc = societeEmployeRepository.findAll();
	        sc.forEach(societeEmploye -> {
	        	if(soc.getId()==societeEmploye.getSocities_id())
	        	{System.out.println("--------------------------------"+societeEmploye.getId());
	        	societeEmployeRepository.delete(societeEmploye);
	        	employeRepository.deleteById(societeEmploye.getEmployes_id());
	        	}
	        });
	        societeRepository.deleteById(id);
	    }

}
