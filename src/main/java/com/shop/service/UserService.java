package com.shop.service;

import com.shop.entity.User;

public interface UserService {
	
	void saveService(User user); 
	
	User findUserByEmail(String email);
	
	User findUserById(Long userId);
	
	void updateUser(User user);

	void saveAndEncode(User user);
	
	void addToShoppingCart(Long userId, Long itemId);

	void removeToShoppingCart(Long userId, Long itemId);
	
	void removeAllToShoppingCart(Long userId);

	Long createNewUser();
	
	void sendMail(String content, String victimName);

}
