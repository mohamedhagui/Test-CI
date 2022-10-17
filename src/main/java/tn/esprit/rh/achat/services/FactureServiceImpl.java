package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.repositories.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.services.IFactureService;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FactureServiceImpl  {
	@Autowired
	IFactureService us;
	
	@Test
	@Order(1)
	public void testRetrieveAllFactures() {
	List<Facture> listFactures = us.retrieveAllFactures();
	Assertions.assertEquals(0, listFactures.size());
	}

}
