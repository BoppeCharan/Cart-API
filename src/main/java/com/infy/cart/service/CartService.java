package com.infy.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.cart.entity.Cart;
import com.infy.cart.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public Cart addToCart(Cart cart) {
		return cartRepository.save(cart);
	}

	public List<Cart> getCartList() {
		return cartRepository.findAll();
	}

	public Cart getCartById(Long cartId) {
		return cartRepository.findByCartId(cartId);
	}

	public List<Cart> getCartOfUser(Long userId) {
		return cartRepository.findByUserId(userId);
	}

	public Cart updateCart(Long cartId, Cart cart) {
		Cart db = cartRepository.findByCartId(cartId);
		db.setCartId(cartId);
		db.setProductId(cart.getProductId());
		db.setQuantity(cart.getQuantity());
		db.setSellerId(cart.getSellerId());
		db.setUserId(cart.getUserId());
		return cartRepository.save(db);
	}

	public String deleteCartItemById(Long cartId) {
		Cart db = cartRepository.findByCartId(cartId);
		cartRepository.delete(db);
		return "deleted";
	}
	
	
}
