package com.generali.burritoorderingservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@ControllerAdvice
public class BurritoOrderingController {
	
	@Autowired
	private BurritoOrderingService burritoOrderingService;
	
	
	@GetMapping(path="/orders/{orderID}")
	@ResponseStatus(HttpStatus.OK)
	public String getOrderById(@PathVariable String orderID) {
		return burritoOrderingService.getOrder(Long.parseLong(orderID)).toString();
	}
	
	
	@GetMapping(path="/allOrders")
	@ResponseStatus(HttpStatus.OK)
	public List<BurritoOrder> getAllOrders() {
		return burritoOrderingService.getAllOrders();
	}

	
	@PostMapping(path="/order")
	@ResponseStatus(HttpStatus.CREATED)
	public String createOrder(@RequestBody BurritoOrder burritoOrder) {
		
		return "Order Created Successfully !! Order Number  :: "+burritoOrderingService.createOrder(burritoOrder).toString();
		
	}
	
	
	//Exception Handling
		@ExceptionHandler(value=AppException.class)
		public ResponseEntity<Object> exception(AppException exception){
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		
}
