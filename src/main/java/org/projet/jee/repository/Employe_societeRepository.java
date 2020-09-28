package org.projet.jee.repository;


import java.util.List;

import org.projet.jee.model.Employe;
import org.projet.jee.model.Employe_societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource
public interface Employe_societeRepository extends JpaRepository<Employe_societe, Integer> {


}
