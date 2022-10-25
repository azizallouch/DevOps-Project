package tn.esprit.rh.achat.service;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Operateur;

import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class OperateurServiceImplTest {
	
	  @Autowired
	    IOperateurService Os;

	    @Test
	    @Order(1)
	    void retrieveAllOperateurs() {
	        List<Operateur> listUsers = Os.retrieveAllOperateurs();
	        assertEquals(0, listUsers.size());
	    }

	    @Test
	    void addOperateur() {
	    	Operateur o1 = new Operateur();
	        o1.setNom("Operateur test");
	        o1.setPrenom("test2");
	        o1.setPassword("test");
	        Operateur savedOperateur1= Os.addOperateur(o1);
	        assertEquals(o1.getPassword(), savedOperateur1.getPassword());
	    }

	    @Test
	    void deleteOperateur() {
	        Os.deleteOperateur(0L);
	    }
	
//	    @Test
//	    void updateStock() {
//	        Stock s1= St.retrieveStock(0L);
//	        s1.setQte(100);
//	        Stock updatedStock1= St.updateStock(s1);
//	        assertEquals(s1.getQte(), updatedStock1.getQte());
//	    }

	    @Test
	    void retrieveOperateur() {
	    	Os.retrieveOperateur(0L);
	    }

	    
}
