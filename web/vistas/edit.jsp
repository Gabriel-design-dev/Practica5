
<%@page import="Modelo.Productos"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
          <div class="container">
            <div class="col-lg-6">
              <%
              ProductoDAO dao=new ProductoDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Productos p=(Productos)dao.list(id);
          %>
            <h1>Modificar Producto</h1>
            <form action="Controlador">
                Descripcion:<br>
                <input class="form-control" type="text" name="txtdescripcion" value="<%= p.getDescripcion()%>"><br>
                Stock: <br>
                <input class="form-control" type="text" name="txtstock" value="<%= p.getStock()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= p.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
