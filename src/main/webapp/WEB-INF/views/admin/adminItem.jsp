<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<div class="row form-maggin">
	<div class="col-md-10 col-xs-10">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/item"
					method="POST" modelAttribute="item" enctype="multipart/form-data">
					<div class="form-group">
						<label for="name" style="color: red; text-align: left;"
							class="col-sm-10 col-sm-offset-2 control-label"><form:errors
								path="name" /></label>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<form:input class="form-control" path="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="price" class="col-sm-2 control-label">Price</label>
						<div class="col-sm-10">
							<form:input class="form-control" path="price" />
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">Description</label>
						<div class="col-sm-10">
							<form:textarea rows="4" cols="50" maxlength="398" class="form-control" path="description" />
						</div>
					</div>
					<div class="form-group">
						<label for="brandId" class="col-sm-2 control-label">Brand</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="brandId"
								items="${brands}" itemValue="id" itemLabel="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="categoryId" class="col-sm-2 control-label">Category</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="categoryId"
								items="${categories}" itemValue="id" itemLabel="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="countryId" class="col-sm-2 control-label">Country</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="countryId"
								items="${countries}" itemValue="id" itemLabel="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="file" class="col-sm-2 control-label">Image</label>
						<div class="col-sm-10">
							<input name="file" id="file" type="file">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary">Create</button>
							<a href="/admin/item/cancel" class="btn btn-primary">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-xs-4">
				<h3>Name</h3>
			</div>
			<div class="col-md-4 col-xs-4">
				<h3>Update</h3>
			</div>
			<div class="col-md-4 col-xs-4">
				<h3>Delete</h3>
			</div>
		</div>
		<c:forEach items="${page.content}" var="item">
			<div class="row" id="itemHover">
				<div class="col-md-4 col-xs-4">${item.name}</div>
				<div class="col-md-4 col-xs-4">
					<a class="btn btn-success"
						href="/admin/item/update/${item.id}<custom:allParams/>">Update</a>
				</div>
				<div class="col-md-4 col-xs-4">
					<a class="btn btn-danger"
						href="/admin/item/delete/${item.id}<custom:allParams/>">Delete</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col-md-2 col-xs-2">
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
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>
<script>
	$('label').each(function() {
		if (!$(this).html())
			$(this).parent('div').hide();
	});
</script>