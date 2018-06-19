package com.shop.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shop.enumeration.Role;

@Entity
@Table(name="user")
public class User extends Base implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="second_name")
	private String secondName;
	
	@Column(name="age")
	private short age;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Transient
	@Column(name="confirm_password")
	private String confirmPassword;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Enumerated
	private Role role; 
	
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "file_data", columnDefinition = "MEDIUMBLOB")
	private byte[] fileData;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ShopingCart shopingCart;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(role.name())));
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public ShopingCart getShopingCart() {
		return shopingCart;
	}

	public void setShopingCart(ShopingCart shopingCart) {
		this.shopingCart = shopingCart;
	}

}
