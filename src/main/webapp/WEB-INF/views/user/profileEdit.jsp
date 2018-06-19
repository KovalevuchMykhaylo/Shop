<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-md-12">
		<form:form action="/user/profile/edit" method="POST"
			modelAttribute="updatedUser" enctype="multipart/form-data">
			<div class="col-md-6 form-maggin">
				<label class="control-label">First name</label>
				<form:input path="firstName" cssClass="form-control"
					title="First name" />
				<label class="control-label">Second name</label>
				<form:input path="secondName" cssClass="form-control"
					title="Second name" />
				<label class="control-label">Phone number</label>
				<form:input path="phoneNumber" cssClass="form-control"
					title="Phone number" />
			</div>
			<div class="col-md-6 form-maggin">
				<label class="control-label">Avatar</label> 
				<input name="file" id="file" type="file" title="Phone number" />
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<span class="input-group-btn"> <input type="submit"
							class="btn btn-primary btn-block" value="Update">
						</span>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</div>