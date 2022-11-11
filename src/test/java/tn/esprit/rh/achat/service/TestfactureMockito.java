package tn.esprit.rh.achat.service;

import org.assertj.core.api.Assertions;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentCaptor;
import static org.junit.Assert.*;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;


import static org.mockito.Mockito.*;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.*;
import tn.esprit.rh.achat.services.FactureServiceImpl;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class TestfactureMockito {
	@Mock
	FactureRepository facturerepo;

   @InjectMocks
   FactureServiceImpl factureService;
    //Fournisseur f=Fournisseur.builder().idFournisseur(1L).code("123").libelle("test1")
         //   .categorieFournisseur(null).detailFournisseur(null).factures(null)
          //  .secteurActivites(null).build();
   
    	 
  /*  	Facture f = new Facture(2L,233,11,null,null,true,null,null,null);
     factureService.addFacture(f);
        
        Mockito.when(facturerepo.findById(2L))
        Assertions.assertThat(factureService.retrieveFacture(2L)).isEqualTo(f);*/
    
    @Test
    public void retrieveFacture(){
        Facture f = new Facture(1L,233,11,null,null,true,null,null,null);

        Mockito.when(facturerepo.findById(1L)).thenReturn(Optional.of(f));
        Facture Facture= factureService.retrieveFacture((long) 1);
        Assertions.assertThatObject(Facture).isEqualTo(Facture);
        log.info("get ==>"+ Facture.toString());
    }
    
    
    @Test
    public void  addFacture(){
    	Facture f = new Facture(2L,233,11,null,null,true,null,null,null);
   
        Mockito.when(facturerepo.save(f)).thenReturn(f);

        Assertions.assertThat(factureService.addFacture(f)).isEqualTo(f);
      
    }

    @Test
    public void retrieveAllFactures()
    {
        List<Facture> Lf = new ArrayList<Facture>() {
			private static final long serialVersionUID = 1L;

			{
                add(new Facture(3L,233,11,null,null,true,null,null,null));
                add(new Facture(4L,233,11,null,null,true,null,null,null));
                add(new Facture(5L,233,11,null,null,true,null,null,null));
            }};
           

       Mockito.when(facturerepo.findAll()).thenReturn(Lf);
        //test
        List<Facture> factureList = factureService.retrieveAllFactures();
        Assertions.assertThat(factureService.retrieveAllFactures()).isEqualTo(Lf);
        log.info("retrieve all ==>"+ factureList.toString());

    }

    @Test
    public void cancelFacture() {
    	Facture f = new Facture(6L,233,11,null,null,true,null,null,null);
      //  log.info("delete ==>"+ f.toString());
		when(facturerepo.save(f)).thenReturn(f);
		assertNotNull(f);
		f.setArchivee(true);
        Assertions.assertThat(factureService.cancelFacture(f)).isEqualTo(f);

		log.info("update ==>"+ f.toString());
	

    }
   /*@Test
   /*
    public void  pourcentageRecouvrement()
    {
       
	   factureService.pourcentageRecouvrement(Date(10-12-1998),Date(12-12-2010));
    }
*/
}

