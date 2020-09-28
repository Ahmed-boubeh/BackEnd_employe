package org.projet.jee.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.projet.jee.model.EmpSocid;
import org.projet.jee.model.Employe;
import org.projet.jee.model.Employe_societe;
import org.projet.jee.model.Societe;
import org.projet.jee.repository.EmployeRepository;
import org.projet.jee.repository.Employe_societeRepository;
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
public class EmployeController {

	@Autowired
	private EmployeRepository employeRepository;
	
	@Autowired
	private Employe_societeRepository societeEmployeRepository;
	
	@PostMapping("/addEmploye")
	public String saveEmploye(@RequestBody Employe employe) {
	    employeRepository.save(employe);
	    return "added employe whith id :" + employe.getId();
	}
	
	
	@PostMapping("/addEmp")
	public String saveEmployee(@RequestBody EmpSocid employe) {
		Employe emple = new Employe();
		emple.setNom(employe.getNom());
		emple.setSalaire(employe.getSalaire());
	    employeRepository.save(emple);
	    Employe_societe emp = new Employe_societe();
	    emp.setEmployes_id(emple.getId());
	    emp.setSocities_id(employe.getSociete_id());
	    societeEmployeRepository.save(emp);
	    return "added employe whith id :" + emp.getId();
	}
	
	
	
	
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Object> EditEmploye(@PathVariable int id ,@RequestBody Employe employe) {
		Optional<Employe> emp = employeRepository.findById(id);
		if (!emp.isPresent())
			return ResponseEntity.notFound().build();
		
		employe.setId(id);
		
		employeRepository.save(employe);

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/findAllEmploye")
	public Iterable<Employe> getEmploye(){
		return employeRepository.findAll();
	}
	
	@GetMapping("/findAllEmploye/{id}")
	public Optional<Employe> getEmploye(@PathVariable int id){
		return employeRepository.findById(id);
	}
	
	
	 @GetMapping(path = "/deleteEmp/{idEmp}")
	    public void deleteEmp(@PathVariable("idEmp") Integer idEmp){
	        int id = Integer.valueOf(idEmp);
	        Employe emp = employeRepository.findById(id).get();
	        System.out.println("--------------------------------"+emp.getId());
	        List<Employe_societe> sc = new ArrayList<>() ;
	        sc = societeEmployeRepository.findAll();
	        sc.forEach(societeEmploye -> {
	        	if(emp.getId()==societeEmploye.getEmployes_id())
	        	{System.out.println("--------------------------------"+societeEmploye.getEmployes_id());
	        	societeEmployeRepository.delete(societeEmploye);}
	        });

	       employeRepository.deleteById(id);

	    }

	
	@GetMapping("/searchEmpByName/{key}")
    public List<Employe> getEmployesByName(@PathVariable("key") String key){
        List<Employe> employes = new ArrayList<>();

        employes  = employeRepository.findByNomContains(key+"");

        return employes;
    }

	
}
