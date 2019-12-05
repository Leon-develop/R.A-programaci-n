<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html lang="es">
    <head>
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    </head>
    <body>
        <div class="container">
            <header>
                <h2>${message}</h2>
                Click on this <strong><a href="next">link</a></strong> to visit another page.
            </header>

            <h1>Productos</h1>
            <h2>Empleando los parámetros Model</h2>
            <div class="starter-template">
                <table class="table table-striped table-hover table-condensed table-bordered">
                    <tr>
                     <th>Id</th>
                     <th>Nombre</th>
                     <th>Descripción</th>
                    </tr>
                    <c:forEach var="producto" items="${productos}">
                     <tr>
                      <td>${producto.id}</td>
                      <td>${producto.nombre}</td>
                      <td>${producto.descripcion}</td>
                     </tr>
                    </c:forEach>
                </table>
            </div>

<!-- -- >
            <h2>Empleando la rest Api</h2>
            <div class="starter-template">
                <table id="productosTable" class="display">
                   <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Descripcion</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>id</th>
                            <th>nombre</th>
                            <th>descripcion</th>
                        </tr>
                    </tfoot>
                </table>
            </div>
-->

        </div>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
    	<script src="${contextPath}/resources/js/datatable.js"></script>
    </body>

</html>
