package org.Spring.aout.MySpring;

import org.Spring.aout.MySpring.entities.Produit;
import org.Spring.aout.MySpring.repositoty.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MySpringApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;

	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {

		SpringApplication.run(MySpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Produit.class); //Pour afficher les Id
		produitRepository.save(new Produit(null , "Ordinateur Lx 45", (double) 6700,3));
		produitRepository.save(new Produit(null , "Smartphone BbKey3", (double) 900, 34));
		produitRepository.save(new Produit(null , "Mac Book Prp ", (double) 1900, 314));
		produitRepository.save(new Produit(null , "Ipad 3", (double) 700, 54));
		produitRepository.save(new Produit(null , "Drone 23po", (double) 300, 134));
		produitRepository.save(new Produit(null , "Hover Board hb23z", (double) 200, 134));

		produitRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});

	}
}
