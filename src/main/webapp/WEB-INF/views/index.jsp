<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="row">
	<sec:authorize access="!isAuthenticated()">
		<h3 id="blink">To buy you need to register!!!</h3>
	</sec:authorize>
	<div class="col-md-10 col-xs-10 parent">
		<c:forEach items="${page.content}" var="item">
			<div id="itemHover">
				<a href="/iteminfo/${item.id}"> <img
					src="data:image/jpg;base64, ${item.img}" class="img-rounded"
					width="100" />
					<p>Name: ${item.name}</p>
					<p>Price: ${item.price} грн</p>
				</a>
				<sec:authorize access="isAuthenticated()">
					<a href="/buy/${item.id}" class="btn btn-primary">В корзину!</a>
				</sec:authorize>
			</div>
		</c:forEach>
	</div>
	<div class="col-md-2 col-xs-2 form-maggin">
		<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="name" />
						<custom:sort innerHtml="Name desc" paramValue="name,desc" />
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
			<form:form class="form-inline" action="/" method="GET"
				modelAttribute="filter">
				<div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						Categoryes
						<form:checkboxes element="div" items="${category}" itemValue="id"
							itemLabel="name" path="categoryIds" />
					</div>
					<div class="col-md-6 col-xs-6 text-center">
						Brands
						<form:checkboxes element="div" items="${brand}" itemValue="id"
							itemLabel="name" path="brandIds" />
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Ok</button>
				<a href  = "/cancel" class="btn btn-primary" >Cancel</a>
			</form:form>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>