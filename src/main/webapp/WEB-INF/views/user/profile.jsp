<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="row">
	<div class="col-md-12">
		<div class="col-md-6 form-maggin">
			<h3>Name: ${user.firstName} <a href="/user/profile/edit" class="btn btn-primary">Edit</a></h3>
			<h3>SecondName: ${user.secondName}</h3>
			<h3>Email: ${user.email}</h3>
		</div>
		<div class="col-md-6 form-maggin">
			<img src="data:image/jpg;base64, ${img}" class="img-rounded" width="300"/>
		</div>
	</div>
</div>