<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="row">
	<div class="col-md-12">
		<div class="col-md-6 form-maggin">
			<h3>Name: ${item.name} <sec:authorize access="isAuthenticated()">
					<a href="/buy/${item.id}" class="btn btn-primary">В корзину!</a>
				</sec:authorize></h3>
			<h3>Brand: ${item.brand.name}</h3>
			<h3>Category: ${item.category.name}</h3>
			<h3>Producer: ${item.country.name}</h3>
			<h3>Price: ${item.price} грн</h3>
			<h4>Description: ${item.description}</h4>
		</div>
		<div class="col-md-6 form-maggin">
			<img src="data:image/jpg;base64, ${img}" class="img-rounded" width="300"/>
		</div>
	</div>
</div>