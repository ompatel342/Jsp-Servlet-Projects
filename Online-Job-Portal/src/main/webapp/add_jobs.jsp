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
</head>
<body style="background-color: #f0f1f2;"> 

<c:if test="${userobj.role ne 'admin'}">
   <c:redirect url="login.jsp"></c:redirect>
   </c:if>
   
<%@ include file="all_component/navbar.jsp"%>

     <div class="container p-2">
       <div class="col-md-10 offset-md-1">
         <div class="card">
           <div class="card-body">
             <div class="text-center text-success">
                <i class="fa fa-user-friends fa-3x"></i>
                
             <c:if test="${not empty msg }">
               <div class="alert alert-success" role="alert">${msg}</div>
               <c:remove var="msg"/>
            </c:if>
            
                <h5>Add Jobs</h5>
             </div>
             <form action="addjob" method="post">
                <div class="form-group">
                    <label>Enter Title</label><input type="text" name="title" required class="form-control">
                </div>
                
                <div class="form-row">
                   <div class="form-group col-md-4">
                     <label>Location</label>
                     <select name="location" class="custom-select " id="inlineFormCustomSelectPref">
                     <option selected>Choose...</option>
                     <option value="Gandhinagar">Gandhinagar</option>
                     <option value="Ahmedabad">Ahmedabad</option>
                     <option value="Vadodara">Vadodara</option>
                     <option value="Surat">Surat</option>
                     <option value="Rajkot">Rajkot</option>
                     <option value="Jamnagar">Jamnagar</option>
                     <option value="Anand">Anand</option>
                     <option value="Nadiad">Nadiad</option>
                     <option value="Ankleshwar">Ankleshwar</option>
                     <option value="Bharuch">Bharuch</option>
                     <option value="Vapi">Vapi</option>
                     
                     </select>
                </div>
                
                <div class="form-group col-md-4">
                  <label>Category</label>
                  <select class="custom-select" id="inlineFormCustomSelectPref" name="category">
                  <option selected>Choose..</option>
                  <option value="IT">IT</option>
                  <option value="Chemical">Chemical</option>
                  <option value="Mechanical">Mechanical</option>
                  <option value="Electrical">Electrical</option>
                  <option value="Instrument & Control">Instrument & Control</option>
                  <option value="HR">HR</option>
                  
                  </select>
                </div>
                
                
              
                 <div class="form-group col-md-4">
                     <label>Status</label>
                     <select name="status" class="form-control ">
                     <option class="Active" value="Active" >Active</option>
                     <option class="Inactive" value="Inactive" >Inactive</option>
                     </select>
                  </div>
                  
               </div>
               
               <div class="form-group">
                  <label>Enter Description</label>
                  <textarea rows="6" cols="" required name="desc" class="form-control"></textarea>
               </div>
               
               <button class="btn btn-success">Publish Job</button>
               
              </form>
              
              </div>
            </div>
          </div>  
         </div>
         
         
     <div style="margin-top:100px;">
        <%@include file="all_component/footer.jsp" %>
     </div> 
         
 </body>
</html>