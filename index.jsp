<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>Spring MVC</title>
</head>
<body style="background-color: #e2e2e2">
<div class="container mt-5">
<h1 align="center" style="font-weight: bold; ">Spring MVC CRUD Example + JDBCTemplate</h1>
<a href="doctorform" class="btn btn-info" style="font-weight: bold;">Add New Doctor</a>
<table class="table mt-5 table-info ">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Specialist</th>
      <th scope="col">City</th>
      <th scope="col">Country</th>
      <th scope="col">Action
      </th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="doc" items="${list}">
    <tr>
      <th scope="row"><c:out value="${doc.id }"/></th>
      <td><c:out value="${doc.name}"/></td>
      <td><c:out value="${doc.email}"/></td>
      <td><c:out value="${doc.specialist}"/></td>
      <td><c:out value="${doc.city}"/></td>
      <td><c:out value="${doc.country}"/></td>
      <td><a href="editdoctorform/<c:out value="${doc.id}"/>" class="btn btn-warning">Edit</a>
      <a href="deletedoctor/<c:out value="${doc.id}"/>" class="btn btn-danger">Delete</a>
      </td>
      
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
  
</body>
</html>