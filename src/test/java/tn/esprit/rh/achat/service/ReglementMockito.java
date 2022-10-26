package tn.esprit.rh.achat.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;

@SpringBootTest(classes = AchatApplication.class)
@ExtendWith(MockitoExtension.class)

@Slf4j

// TESTE LE DIMANCHE 23 OCTOBRE A 19H50 : TOUTE LES FONCTIONS MARCHENT
// 
public class ReglementMockito {
	
	
	@Mock
	ReglementRepository reglementRepository;
    
    @InjectMocks
    ReglementServiceImpl RegService;

    Reglement reglement = new Reglement(4L,5.4f,5.4f);
    
    List<Reglement> listRegs = new ArrayList<Reglement>() {
        {
            add(new Reglement(1L,5.4f,5.4f));
            add(new Reglement(2L,5.4f,5.4f));
            add(new Reglement(3L,5.4f,5.4f));
        }
    };

    
    
    
    /*
    Récupération de tous les reglements
    */
    
  @Test
    
    void retrieveAllReglements() {
	  
		
      Mockito.when(reglementRepository.findAll()).thenReturn(listRegs);    
     
      Assertions.assertNotNull(RegService.retrieveAllReglements());
        
    }
  
  
  /*
  Ajout d'un stock
  */

  @Test
  
  void addReglement() {
	  
	  Reglement reglement1 = new Reglement(7L,5.4f,5.4f);
	  
      Mockito.when(reglementRepository.save(reglement1)).thenReturn(reglement1);
      
      assertEquals(reglement1, RegService.addReglement(reglement1));
      
      Mockito.verify(reglementRepository).save(reglement1);
  }
    
 /*
    Récupération d'un stock
   */

    @Test
 
  
    void retrieveReglement() {
    	
        Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
        
        Reglement reglement1 = RegService.retrieveReglement(4L);
        
        Assertions.assertNotNull(reglement1);
    }
    
	
	

}
