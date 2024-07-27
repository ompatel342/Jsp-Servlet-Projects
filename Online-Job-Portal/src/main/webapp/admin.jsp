<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="all_component/all_css.jsp"%>
<style type="text/css">
.back-img {
       background: url("img/admin.jpg");
       width: 100%;
       height: 88vh;
       background-repeat:no-repeat;
       background-size: cover;
}

    
h1 {
         background-color: black;
         width: 100%;
         height: 11vh;
}
   
</style>
</head>
<body>
   
   <c:if test="${userobj.role ne 'admin'}">
   <c:redirect url="login.jsp"></c:redirect>
   </c:if>

   <%@ include file="all_component/navbar.jsp"%>
   <div class="container-fluid back-img">
       <div class="text-center">
          <h1 class="text-white p-4">
             <i class="fa fa-book" aria-hidden="true"></i>Admin Panel
          </h1>
       </div>
   </div>
   
   <%@ include file="all_component/footer.jsp" %>

</body>
</html>