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
<title>Home: User</title>
<%@ include file="all_component/all_css.jsp"%>
</head>
<body>

<%@ include file="all_component/navbar.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h5 class="text-center text-primary">All Jobs</h5>

            <form class="form-inline" action="more_view.jsp" method="get">
                <div class="form-group col-md-5 mt-1">
                    <label for="locationSelect"><h5>Location</h5></label>
                    <select name="loc" id="locationSelect" class="custom-select">
                        <option value="" disabled selected>Choose..</option>
                        <option value="Gandhinagar">Gandhinagar</option>
                        <!-- Add other locations here -->
                    </select>
                </div>

                <div class="form-group col-md-5 mt-1">
                    <label for="categorySelect"><h5>Category</h5></label>
                    <select name="cat" id="categorySelect" class="custom-select">
                        <option value="" disabled selected>Choose..</option>
                        <option value="IT">IT</option>
                        <!-- Add other categories here -->
                    </select>
                </div>

                <button type="submit" class="btn btn-success">Submit</button>
            </form>

            <div class="card mt-2">
                <div class="card-body">
                    <% 
                    JobDao jd = new JobDao(Db_Connection.get_conn());
                    List<Jobs> list = jd.view_jobs_user();
                    for (Jobs j : list) {
                    %>        
                        <div class="card mt-2">
                            <div class="card-body">
                                <div class="text-center text-primary">
                                    <i class="far fa-clipboard fa-2x"></i>
                                </div>
                                <h6><%=j.getTitle()%></h6>
                                <p>
                                    <%= j.getDecription().length() > 100 ? j.getDecription().substring(0, 100) + "...." : j.getDecription() %>
                                </p>
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <input type="text" class="form-control form-control-sm" value="Location: <%=j.getLocation()%>" readonly>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <input type="text" class="form-control form-control-sm" value="Category: <%=j.getCategory()%>" readonly>
                                    </div>
                                </div>
                                <h6>Publish Date: <%=j.getPdate() %></h6>
                                <div class="text-center">
                                    <a href="view_more.jsp?id=<%=j.getId() %>" class="btn btn-sm bg-success text-white">View More</a>
                                </div>
                            </div>
                        </div>
                    <% 
                    }
                    %>
                </div>
            </div>

        </div>
    </div>

    <div style="margin-top: 340px;">
        <%@ include file="all_component/footer.jsp"%>
    </div>
</div>

</body>
</html>
