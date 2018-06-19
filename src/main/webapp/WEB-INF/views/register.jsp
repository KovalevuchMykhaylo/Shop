<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Register</h3>
					<form:form method="POST" action="/register" modelAttribute="registerModel">
						<div class="form-group">
							<form:errors path="*" cssClass="error" style="color:red"/>
						</div>
						<div class="form-group">
  							<label class="control-label">E-mail address</label>
							<form:input path="email" cssClass="form-control" title="E-mail address" />
											
							<label class="control-label">Password</label>
							<form:password path="password" cssClass="form-control" title="Password" />
							
							<label class="control-label">Password Confirmation</label>
							<form:password path="confirmPassword" cssClass="form-control" title="Password Confirmation" />
							
<%-- 							<label class="control-label">Who are you?</label>
							<form:select path="role" cssClass="form-control">
								<c:forEach items="${userRole}" var="role">
									<c:if test="${role ne 'ROLE_ADMIN'}">
										<form:option value="${role}">${role.role}</form:option>
									</c:if>
								</c:forEach>
							</form:select> --%>
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary btn-block" value="Register">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>