package tn.esprit.rh.achat.services;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

@SpringBootTest(classes=AchatApplication.class)
@TestMethodOrder(OrderAnnotation.class)
public class ProduitServiceImplTest {

@Autowired
IProduitService ps;
@Test
@Order(1)
public void testRetrieveAllProduits() {
List<Produit> listProduits = ps.retrieveAllProduits();
Assertions.assertEquals(0, listProduits.size());
}


@Test
void addProduit() {
    Produit p1 = new Produit();
    p1.setLibelleProduit("produit test");
    p1.setPrix(10);
    p1.setCodeProduit("15");
    Produit savedProduct1= ps.addProduit(p1);
    assertEquals(p1.getLibelleProduit(), savedProduct1.getLibelleProduit());
}

//@Test
//void deleteProduit() {
// ps.deleteProduit(0L);
// }
//
//@Test
//void updateStock() {
//    Stock s1= St.retrieveStock(0L);
//    s1.setQte(100);
//    Stock updatedStock1= St.updateStock(s1);
//    assertEquals(s1.getQte(), updatedStock1.getQte());
//}

@Test
void retrieveProduit() {
    ps.retrieveProduit(0L);
}



}


