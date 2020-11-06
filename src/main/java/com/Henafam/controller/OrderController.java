package com.Henafam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Henafam.model.Order;
import com.Henafam.service.OrderService;


@CrossOrigin("*")
@RestController
@RequestMapping ("/Order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping
	public ResponseEntity< List<Order>> getAllOrder() {
		 return orderService.getAllOrder ();
		
	}
	@PostMapping
	public ResponseEntity <Order> createOrder (@RequestBody Order order){
	   return orderService.createOrder(order);

     }
	 @GetMapping("/page")
	    public ResponseEntity<Map<String, Object>> getAllOrderInPage(
	    		@RequestParam(name = "pageNo", defaultValue = "0") int pageNo, 
	    		@RequestParam(name = "pageSize", defaultValue = "2") int pageSize, 
	    		@RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
			return orderService.getAllOrderInPage(pageNo, pageSize, sortBy);
		}
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus>  deleteById(@PathVariable String id) {
		 return orderService.deleteById(id);
	 }

}
