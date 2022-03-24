
package com.generali.burritoorderingservice;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BurritoOrderingService {
	
	
	@Autowired
	private BurritoOrderRepository burritoOrderRepository;
	
	public BurritoOrder getOrder(Long orderId) {
		return burritoOrderRepository.getById(orderId);
	}
	
	
	
	public Long createOrder(BurritoOrder burritoOrder) {
		
		//validate the input value 
		
		// Validation to choose atleast 1 Tortilla from {corn, flour}
				if (!AppConstants.TORTILLA.contains(burritoOrder.getTortilla())) {
					throw new AppException("Choose atleast 1 Tortilla from {corn, flour}", new Throwable());
				}

				// Validation to choose atleast 1 Protein from {bean, beef, chicken, pork,
				// shrimp, steak}
				if (!AppConstants.PROTEIN.contains(burritoOrder.getProtein())) {
					throw new AppException("Choose atleast 1 Protein from {bean, beef, chicken, pork, shrimp, steak}",
							new AppException());
				}

				// Validation to choose 0 or more of veggies {cabbage, corn, jalapenos}}
				for (String veggie : burritoOrder.getVegetables()) {
					if (!AppConstants.VEGETABLES.contains(veggie))
						throw new AppException("Choose 0 or more veggie from {cabbage, corn, jalapenos}", new Throwable());
				}

				// Validation to choose atleast 1 salsa type {mild, medium, hot}
				if (!AppConstants.PROTEIN.contains(burritoOrder.getProtein())) {
					throw new AppException("Choose atleast 1 Salsa from {mild, medium, hot}", new Throwable());
				}

				// Validation to choose 0 or more of extra avocado}
				for (String extra : burritoOrder.getExtras()) {
					if (!AppConstants.EXTRAS.contains(extra))
						throw new AppException("Choose 0 or more from {avocado}", new Throwable());
				}
		
		burritoOrderRepository.save(burritoOrder);
		
		return burritoOrder.getOrderId();
	}



	public List<BurritoOrder> getAllOrders() {
		return burritoOrderRepository.findAll();
		
	}
	
	

}
