package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Facture;

import tn.esprit.rh.achat.services.IFactureService;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AchatApplication.class)
@TestMethodOrder(OrderAnnotation.class)
 public class testfactureJUNIT {

    @Autowired
    IFactureService Fa;

    @Test
    @Order(1)
    void retrieveAllFactures() {
        List<Facture> listUsers =Fa.retrieveAllFactures();
        assertEquals(0, listUsers.size());
    }
  
    @Test
    void retrieveFacture() {
    	Facture f= new Facture(770L,8.5f,9.6f);
        Fa.retrieveFacture(f.getIdFacture());
    }

   
}


	

