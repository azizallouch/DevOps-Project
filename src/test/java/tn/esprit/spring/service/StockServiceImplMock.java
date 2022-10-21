
package tn.esprit.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import lombok.extern.slf4j.Slf4j;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest(classes = AchatApplication.class)
@ExtendWith(MockitoExtension.class)

@Slf4j

public class StockServiceImplMock {

    @Mock
    StockRepository stockRepository;
    
    @InjectMocks
    StockServiceImpl StockSer;

    Stock stock = new Stock(1L,"stock tunis", 12, 5);
    
    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            add(new Stock("stock ariana", 1, 1));
            add(new Stock("stock mannouba", 1, 1));
            add(new Stock("stock jandouba", 1, 1));
        }
    };

    
    /*
    Récupération d'un stock
    */

    @Test
    
    void retrieveStock() {
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stock1 = StockSer.retrieveStock(0L);
        Assertions.assertNotNull(stock1);
    }
    
    /*
    Ajout d'un stock
    */

    @Test
    
    void addStock() {
		Stock stock = new Stock("stock ariana", 1, 1);
        Mockito.when(stockRepository.save(stock)).thenReturn(stock);
        assertEquals(stock, StockSer.addStock(stock));
    }
    
    /*
     Suppression du stock
     */
//
//    @Test
//    
//        void deleteStock() {
//    	
//    	 Stock stock1 = new Stock(3L,"stock tunis", 12, 5);
//    	
//    	  StockSer.deleteStock(stock1.getIdStock());
//    	  Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock1));
//    	  verify(stockRepository, times(1)).delete(stock1); 
//   
//       }
//    
//    
   
    
    /*
    Récupération du status d'un stock
    */
    @Test
    
    void retrieveStatusStock() {
    	
        Mockito.when(stockRepository.retrieveStatusStock()).thenReturn( List.of(new Stock("stock ariana", 1, 1)));
        Assertions.assertNotNull(StockSer.retrieveStatusStock());

    }
    
    /*
    Récupération de tous les stocks
    */
    
  @Test
    
    void retrieveAllStocks() {
	  
		Stock stock1 = new Stock("stock 1", 1, 1);
		Stock stock2 = new Stock("stock 2", 1, 1);
		
		List<Stock> stockList = new ArrayList<Stock>();
		
		stockList.add(stock1);
		stockList.add(stock2);
		
        Mockito.when(stockRepository.findAll()).thenReturn(stockList);       
        Assertions.assertEquals(2,StockSer.retrieveAllStocks().size());
        
    }

  
  @Test
  
  void updateStock() {
	  
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stock1 = StockSer.retrieveStock(0L);
        stock1.setLibelleStock("loulou");
        Mockito.when(stockRepository.save(stock1)).thenReturn(stock1);
        Assertions.assertEquals(stock1.getLibelleStock(), StockSer.updateStock(stock1).getLibelleStock());
        log.info("la nouvelle valeur est est " + stock1.getLibelleStock());
        

 }
  

  
}