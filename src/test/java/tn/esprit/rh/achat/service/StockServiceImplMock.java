package tn.esprit.rh.achat.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import lombok.extern.slf4j.Slf4j;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
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

//TESTE LE DIMANCHE 23 OCTOBRE A 19H50 : TOUTE LES FONCTIONS MARCHENT
//

public class StockServiceImplMock {

    @Mock(lenient = true)
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
        Stock stock1 = StockSer.retrieveStock(1L);
        Assertions.assertNotNull(stock1);
    }

 /*
    Ajout d'un stock
    */

    @Test
    
    void addStock() {
		Stock stock = new Stock(10L,"stock binzarrtt", 1, 1);
        Mockito.when(stockRepository.save(stock)).thenReturn(stock);
        assertEquals(stock, StockSer.addStock(stock));
    }
    
/*
     Suppression d'un stock selon son ID (PROBLEM FIXED)
     */

    
    @Test
    
        void deleteStock() {
    	
    	Stock stock1 = new Stock(40L,"stock tunis", 12, 5);
    	  Mockito.when(stockRepository.findById(stock1.getIdStock())).thenReturn(Optional.of(stock1));
      	StockSer.deleteStock(stock1.getIdStock());
       Mockito.verify(stockRepository).deleteById(stock1.getIdStock());

   
       }
    
  
}