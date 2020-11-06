package com.Henafam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Henafam.model.Order;

import com.Henafam.repository.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	

	public ResponseEntity< List<Order>> getAllOrder () {
		try {
			List<Order> order= orderRepository.findAll();
			if (order.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<> (order,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

    public ResponseEntity<Order> createOrder(Order order) {
    	try {
    		Order oru = orderRepository.insert(order);
			return new ResponseEntity<>(oru,HttpStatus.CREATED);
		 }catch (Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}

	public ResponseEntity<Map<String, Object>> getAllOrderInPage(int pageNo, int pageSize, String sortBy) {
		try {
			Map<String, Object> response = new HashMap<>();
		    Sort sort = Sort.by(sortBy);
			Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		    Page<Order> page = orderRepository.findAll(pageable);
		    response.put("data", page.getContent());
		    response.put("Total no of pages", page.getTotalPages());
		    response.put("TotalNoOfElements", page.getTotalElements());
		    response.put("Current page no", page.getNumber());
		    
		    return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<HttpStatus> deleteById(String id) {
			try {
				orderRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	

}
