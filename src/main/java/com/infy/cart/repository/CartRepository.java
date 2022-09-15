package com.infy.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.cart.entity.*;

public interface CartRepository extends JpaRepository< Cart, Long >  {

	Cart findByCartId(Long cartId);

	List<Cart> findByUserId(Long userId);
}
