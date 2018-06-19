<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/">Main</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<sec:authorize access="isAuthenticated()">
					<li><a href="/user/profile">Profile</a></li>
				</sec:authorize>
				<li><a href="/about">About</a></li>
<!-- 				<li><a href="#">Projects</a></li> -->
<!-- 				<li><a href="#">Contact</a></li> -->
				<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
					<li><a href="/admin/country">AdminCounrty</a></li>
					<li><a href="/admin/brand">AdminBrand</a></li>
					<li><a href="/admin/category">AdminCategory</a></li>
					<li><a href="/admin/item">AdminItem</a></li>
				</sec:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="!isAuthenticated()">
					<li><a href="/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					<li><a href="/register"> Register</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
			       <li><a href="/shopping">Корзина <span class="badge">${quantity.count}</span></a></li>
			       <li>
					<form:form action="${pageContext.request.contextPath}/logout"
						method="POST" id="logOutId">
<%-- 						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
						<li style="margin-top: 15px;color=red"><a href="#">Logout</a></li>
					</form:form>
					</li>
			</sec:authorize>
			</ul>
		</div>
	</div>
</nav>
<script>
document.getElementById("logOutId").onclick = function() {
    document.getElementById("logOutId").submit();
}
</script>