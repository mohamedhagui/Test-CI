package tn.esprit.rh.achat.services.produit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.IProduitService;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;




@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceTest {

    @Autowired
    IProduitService ps;
    ProduitRepository produitrepository;

    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }

    
       @Test
    @Order(2)
     void testAddProduit() {
        Date date = new Date();
        Produit p = new Produit("ss","ss",100,date,date);
    	Produit savedStock= ps.addProduit(p);
    assertEquals(p.getLibelleProduit(), savedStock.getLibelleProduit());
    }
    
    @Test
    @Order(3)
     void testRetrieveProduit() {
    	Produit p = ps.retrieveProduit((long) 4);
    assertEquals("4", p.getIdProduit().toString());
    }
    @Test
    @Order(4)
     void testDeleteProduit() {
    	ps.deleteProduit((long) 4);
    assertNull(ps.retrieveProduit((long) 4));
    }

}
