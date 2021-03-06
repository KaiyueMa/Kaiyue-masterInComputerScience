<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<div class="row">
	<div class="col-md-4" role="navigation">

		<ul class="nav nav-pills">
			<c:if test="${empty sessionScope.user}">
				<li><a href="${pageContext.request.contextPath}/UserManageServlet?flag=login"
					style="color: #F22E00">Login</a></li>
			</c:if>
			<c:if test="${!empty sessionScope.user}">
				<li class="info-a"><a
					href="${pageContext.request.contextPath}/UserManageServlet?flag=information"
					style="color: #F22E00"> ${sessionScope.user.username} <span
						class="glyphicon glyphicon-triangle-bottom"
						style="font-size: 5px;margin-left: 7px;" aria-hidden="true">
					</span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/UserManageServlet?flag=information">Manage Account</a></li>
						
						<li role="separator" class="divider"></li>
						<li><a href="${pageContext.request.contextPath}/UserManageServlet?flag=logout"
							class="login-out">Logout</a></li>
					</ul></li>
			</c:if>
			<c:if test="${empty sessionScope.user}">
				<li><a href="${pageContext.request.contextPath}/UserManageServlet?flag=register">Register</a></li>
			</c:if>

		</ul>
	</div>

</div>
<div id="header-nav">
	<nav class="navbar navbar-default" id="header-nav-middle">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/ShowFrontMainPage"><img alt="Brand"
					style="display: inline-block;"
					src="${pageContext.request.contextPath}/image/logo.jpg" width="70px" 
					><span class="logo-word"></span></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a class="a-color"
						href="${pageContext.request.contextPath}/ShowFrontMainPage">Home</a></li>
					
					<li><a class="a-color"
						href="${pageContext.request.contextPath}/UserManageServlet?flag=information">Personal Information</a></li>
					<li><a class="a-color"
						href="${pageContext.request.contextPath}/ShowAddOrder?flag=MyOrder">My Orders</a></li>
					
				</ul>

				<form class="navbar-form navbar-right" role="search" method="post"
					action="${pageContext.request.contextPath}/ShowHeaderServlet">
					<input type="hidden" name="flag" value="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search"
							name="keyword">
					</div>
					<button type="submit" class="btn btn-default">
						<span class="glyphicon glyphicon-search" aria-label="Search"></span>
					</button>
				</form>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</div>
