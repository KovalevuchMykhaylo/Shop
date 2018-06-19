<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row divSlaider">
	<div class="col-md-12 col-xs-12">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img
						src="${pageContext.request.contextPath}/resources/img/banner.jpg" width="300">
				</div>
				<div class="item">
					<img
						src="${pageContext.request.contextPath}/resources/img/images10.jpg" width="300">
				</div>
				<div class="item">
					<img
						src="${pageContext.request.contextPath}/resources/img/images11.jpg" width="300">
				</div>
				<div class="item">
					<img src="${pageContext.request.contextPath}/resources/img/img.jpg" width="300">
				</div>
				<div class="item">
					<img src="${pageContext.request.contextPath}/resources/img/img2.jpg" width="300">
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
</div>
<script type="text/javascript">
	$("#myCarousel").carousel({interval: 5000});
</script>
