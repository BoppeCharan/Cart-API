package com.infy.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.cart.entity.Cart;
import com.infy.cart.service.CartService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class CartController {
	
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart")
	public Cart addToCart(@RequestBody Cart cart) {
		return cartService.addToCart(cart);
	}
	
	
	@GetMapping("/cart")
	public List<Cart> getCartList(){
		return cartService.getCartList();
		
	}
	
	
	@GetMapping("/cart/{id}")
	public Cart getCartById(@PathVariable("id") Long cartId) {
		return cartService.getCartById(cartId);
	}
	
	@GetMapping("/cart/user/{userid}")
	public List<Cart> getCartOfUser(@PathVariable("userid") Long userId) {
		return cartService.getCartOfUser(userId);
	}
	
	
	@PutMapping("/cart/{id}")
	public Cart updateCart(@PathVariable("id") Long cartId, @RequestBody Cart cart) {
		return cartService.updateCart(cartId, cart);
	}
	
	
	@DeleteMapping("/cart/{id}")
	public String deleteCartItemById(@PathVariable("id") Long cartId) {
		return cartService.deleteCartItemById(cartId);
	}

}
