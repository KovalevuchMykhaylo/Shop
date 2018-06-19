<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<form:form class="form-horizontal form-maggin" action="${pageContext.request.contextPath}/login" method="POST">
			<div class="form-group">
				<label for="login" class="col-sm-4 control-label">Login</label>
				<div class="col-sm-4">
					<input class="form-control" name="login" id="login">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-4 control-label">Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="password"
						id="user">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<div class="checkbox">
						<label> <input name="rememberMe" type="checkbox">
							Remember me
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button type="submit" class="btn btn-primary">Sign in</button>
				</div>
			</div>
		</form:form>
				</div>
			</div>

			<div class="already">
				<p>Don't have an account yet?
					<a href="${pageContext.request.contextPath}/register">Register</a>
				</p>
			</div>
		</div>
	</div>
</div>