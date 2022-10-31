package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SecteurActiviteJunit {


        @Autowired
        ISecteurActiviteService Sa;

        @Test
        @Order(1)
        void  retrieveAllSecteurActivite() {
            List<SecteurActivite> listSecteur = Sa. retrieveAllSecteurActivite();
            assertEquals(0, listSecteur.size());
        }

        @Test
        void addSecteurActivite() {
           SecteurActivite sa = new SecteurActivite();
            sa.setLibelleSecteurActivite("stock test");

            SecteurActivite savedSecteur1= Sa.addSecteurActivite(sa);
            assertEquals(sa.getLibelleSecteurActivite(), savedSecteur1.getLibelleSecteurActivite());
        }

    @Test
   void deleteSecteurActivite() {
            Sa.deleteSecteurActivite(0L);
        }

    @Test
    void  updateStock() {
        SecteurActivite sa= Sa.retrieveSecteurActivite(0L);
        sa.setLibelleSecteurActivite("Secteur test");
        SecteurActivite updatedSecteur= Sa.updateSecteurActivite(sa);
        assertEquals(sa.getLibelleSecteurActivite(), updatedSecteur.getLibelleSecteurActivite());
    }

        @Test
        void retrieveStock() {
            Sa.retrieveSecteurActivite(0L);
        }


    }


