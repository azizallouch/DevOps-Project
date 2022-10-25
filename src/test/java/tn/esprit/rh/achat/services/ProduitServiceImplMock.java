


package tn.esprit.rh.achat.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Produit;

import tn.esprit.rh.achat.repositories.ProduitRepository;

import tn.esprit.rh.achat.services.ProduitServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@SpringBootTest(classes=AchatApplication.class)
@ExtendWith(MockitoExtension.class)

public class ProduitServiceImplMock {

    @Mock
    ProduitRepository produitRepository;
   
    @InjectMocks
    ProduitServiceImpl ps;

    Produit produit = new Produit("produiit", "1", 5);
   
    List<Produit> listProduits = new ArrayList<Produit>() {
        {
            add(new Produit("produit1", "1", 5));
            add(new Produit("prdouit2", "1", 5));
            add(new Produit("prdouit3", "1", 5));
        }
    };

    @Test
   
    void retrieveProduit() {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit p1 = ps.retrieveProduit(1L);
        Assertions.assertNotNull(p1);
    }
}