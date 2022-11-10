package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AchatApplication.class)
@TestMethodOrder(OrderAnnotation.class)


public class StockJunitTest {

  @Autowired
  IStockService St;

  
  @Test
  @Order(1)

  
  void addStock() {
      Stock s1 = new Stock();
      s1.setLibelleStock("stock test");
      s1.setQte(10);
      s1.setQteMin(100);
      Stock savedStock1= St.addStock(s1);
      assertEquals(s1.getLibelleStock(), savedStock1.getLibelleStock());
  }

  @Test
  void retrieveAllStocks() {
      List<Stock> listStocks = St.retrieveAllStocks();
      Assertions.assertNotNull(listStocks);
  }


@Test
void updateStock() {
    Stock s1= St.retrieveStock(19L);
    s1.setQte(50);
    Stock updatedStock1= St.updateStock(s1);
    assertEquals(s1.getQte(), updatedStock1.getQte());
}

  @Test
  void deleteStock() {
      St.deleteStock(18L);
  }

  
  @Test
  void retrieveStock() {
      St.retrieveStock(1L);
  }

  @Test
  void retrieveStatusStock() {
      St.retrieveStatusStock();
  }

}