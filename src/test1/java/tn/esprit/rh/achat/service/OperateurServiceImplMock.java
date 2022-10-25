package tn.esprit.rh.achat.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class OperateurServiceImplMock {
	@Mock
    OperateurRepository operateurRepository;
   
    @InjectMocks
    OperateurServiceImpl OperateurSer;
    
    Operateur operateur = new Operateur("op1","teur1","test5");
    
    List<Operateur> listOperateurs = new ArrayList<Operateur>() {
        {
            add(new Operateur("meriem","khattat","123"));
            add(new Operateur("emna","ketata","456"));
            
        }
        
        @Test
        void retrieveOperateur() {
            Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
            Operateur operateur1 = OperateurSer.retrieveOperateur(1L);
            Assertions.assertNotNull(operateur1);
        }
    };
}
