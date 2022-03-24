package com.generali.burritoorderingservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BurritoRepositoryTest {
	
	@Autowired
	private BurritoOrderRepository burritoOrderRepository;
	
	//junit for creating an order
	@Test
	public void saveOrder() {
		String[] veg= {"cabbage"};
		String[] ext= {"avocado"};
		BurritoOrder burritoOrder = BurritoOrder.builder().tortilla("flour").protein("chicken").vegetables(veg).salsa("mild").extras(ext).build();
		burritoOrderRepository.save(burritoOrder);
		Assertions.assertThat(burritoOrder.getOrderId()).isGreaterThan(0);
	}
	
	@Test
	public void getOrder() {
		BurritoOrder burritoOrder = burritoOrderRepository.getById(1L);
		Assertions.assertThat(burritoOrder.getOrderId()).isEqualTo(1L);
		
	}

}
