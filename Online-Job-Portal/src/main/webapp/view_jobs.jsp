<%@page import="com.project.entity.Jobs"%>
<%@page import="java.util.List"%>
<%@page import="com.project.dao.JobDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: View Jobs</title>
<%@ include file="all_component/all_css.jsp"%>
</head>
<body>
   <c:if test="${userobj.role ne 'admin'}">
   <c:redirect url="login.jsp"></c:redirect>
   </c:if>

	<%@ include file="all_component/navbar.jsp"%>
 
       <div class="container">
		<div class="row">
			<div class="col-md-12">

				<h5 class="text-center text-primary">All Jobs</h5>
				<c:if test="${not empty msg }">
					<div class="alert alert-danger" role="alert">${msg}</div>
					<c:remove var="msg" />
				</c:if>
				<%
				JobDao jd = new JobDao(Db_Connection.get_conn());
				List<Jobs> list = jd.view_jobs();
				for (Jobs j : list) {
				%>

				<div class="card mt-2">
					<div class="card-body">
						<div class="text-center text-primary">
							<i class="far fa-clipboard fa-2x"></i>
						</div>

						<h6><%=j.getTitle()%></h6>
						<p><%=j.getDecription()%></p>
						<br>
						<div class="form-row">

							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Location:<%=j.getLocation()%>" readonly>
							</div>

							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Category:<%=j.getCategory()%>" readonly>
							</div>

							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Status:<%=j.getStatus()%>" readonly>
							</div>
						</div>
						<h6>Publish Date:2024-07-09</h6>
						<div class="text-center">
							<a href="edit_jobs.jsp?id=<%=j.getId()%>"class="btn btn-sm bg-success text-white">Edit</a>
						    <a href="deletejob?id=<%=j.getId()%>"class="btn btn-sm bg-danger text-white">Delete</a>
						</div>
					</div>
				</div>


				<%
				}
				%>


			</div>
		</div>
	</div>

	<div style="margin-top: 340px;">
		<%@include file="all_component/footer.jsp"%>
	</div>


</body>
</html>