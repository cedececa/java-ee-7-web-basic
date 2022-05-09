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
        <%@ include file="/WEB-INF/jspf/info-cliente-del-pedido.jspf" %>
        <%@ include file="/WEB-INF/jspf/productos-en-cesta.jspf" %>
        <%@ include file="/WEB-INF/jspf/productos-disponibles.jspf" %>
    </body>
</html>
