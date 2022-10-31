package tn.esprit.rh.achat.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SecteurActiviteMockito {
    @Mock
    SecteurActiviteRepository stockRepository;
    @InjectMocks
    SecteurActiviteServiceImpl SecteurSer;

    SecteurActivite Secteur = new SecteurActivite("test", "test");
    List<SecteurActivite> listSecteur = new ArrayList<SecteurActivite>() {
        {
            add(new SecteurActivite("iimed", "khouna"));
            add(new SecteurActivite("safwen", "ahawa"));
        }
    };
   // @Test

   // void retreiveSecteurActivite() {
     //   Mockito.when(SecteurActiviteRepository.findby(Mockito.anyLong())).thenReturn(Optional.of(stock));
      //  Stock stock1 = StockSer.retrieveStock(1L);
    //    Assertions.assertNotNull(stock1);
  //  }
}
