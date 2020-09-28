package org.projet.jee.repository;


import java.util.List;

import org.projet.jee.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

	List<Employe> findByNomContains(String key);

}
