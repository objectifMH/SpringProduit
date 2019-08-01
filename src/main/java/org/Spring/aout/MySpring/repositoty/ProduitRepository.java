package org.Spring.aout.MySpring.repositoty;

import org.Spring.aout.MySpring.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.awt.print.Pageable;
import java.util.List;


@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @RestResource(path = "/byDesignation")
    List<Produit> findByDesignationContains(@Param("mc") String des);

    /*
    @RestResource(path = "/byDesignationPage")
    Page<Produit> findByDesignationContains(@Param("mc") String des , Pageable pageable);
    */



}
