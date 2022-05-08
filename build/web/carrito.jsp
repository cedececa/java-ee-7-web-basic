<%-- 
    Document   : carrito
    Created on : May 8, 2022, 12:17:18 AM
    Author     : Cheng
--%>

<%@page import="entity.Producto"%>
<%@page import="entity.PedidoProducto"%>
<%@page import="entity.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
        <style>
            table, th, td {
                border: 1px solid;
            }
        </style>
    </head>
    <body>
        <%

            Pedido pedido;
            pedido = (Pedido) request.getAttribute("pedidoEncontrado");
        %>

        <h1>Datos del cliente</h1>
        <% if (pedido != null) {%>
        <div>
            <h4>Nombre:<%=pedido.getClienteId().getNombre()%></h4>
            <h4>Apellidos: <%=pedido.getClienteId().getApellidos()%></h4>
            <h4>Email: <%=pedido.getClienteId().getEmail()%></h4>
        </div>
        <% } else {
        %>

        <h4>No existe este cliente</h4>

        <%}%>




        <h1>Productos en la cesta de la compra:</h1>
        <%
            if (pedido
                    != null && pedido.getPedidoProductoList()
                            .size() > 0) {
        %>
        <table
            ">
            <thead>
            <th>IDPRODUCTO</th>
            <th>DESCRIPCION</th>
            <th>CANTIDAD COMPRADA</th>
            <th>FABRICANTE</th>
            <th>COSTE</th>
        </thead>
        <tbody>

            <%
                for (PedidoProducto elem : pedido.getPedidoProductoList()) {
                    Producto p = elem.getProducto();
            %>
            <tr>

                <td><%=p.getProductoId()%></td>
                <td><%=p.getDescripcion()%></td>
                <td><%=p.getCantidad()%></td>
                <td><%=p.getFabricante()%></td>
                <td><%=p.getCoste()%></td>
            </tr>

            <%
                }
            %>

        </tbody>
    </table>
    <% } else {
    %>

    <h4>No hay productos en su cesta</h4>

    <%}%>


</body>
</html>
