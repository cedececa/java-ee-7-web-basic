/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.PedidoFacade;
import dao.PedidoProductoFacade;
import dao.ProductoFacade;
import entity.Pedido;
import entity.PedidoProducto;
import entity.PedidoProductoPK;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cheng
 */
@WebServlet(name = "AnadirProductoAlCarrito", urlPatterns = {"/AnadirProductoAlCarrito"})
public class AnadirProductoAlCarrito extends HttpServlet {

    @EJB
    PedidoProductoFacade pedidoProductoFacade;
    @EJB
    ProductoFacade productoFacade;
    @EJB
    PedidoFacade pedidoFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idpedido = request.getParameter("idpedido");
        String idproducto = request.getParameter("idproducto");
        String cantidad = request.getParameter("cantidad");

        PedidoProducto pedidoProductoNuevo = new PedidoProducto();
        pedidoProductoNuevo.setCantidad(Short.parseShort(cantidad));
        pedidoProductoNuevo.setProducto(this.productoFacade.find(Integer.parseInt(idproducto)));
        pedidoProductoNuevo.setPedido(this.pedidoFacade.find(Integer.parseInt(idpedido)));

        PedidoProductoPK pedidoProductoPK = new PedidoProductoPK(Integer.parseInt(idpedido), Integer.parseInt(idproducto));
        pedidoProductoNuevo.setPedidoProductoPK(pedidoProductoPK);
        this.pedidoProductoFacade.create(pedidoProductoNuevo);

        RequestDispatcher rd;
        response.sendRedirect(request.getContextPath() + "/Carrito?idpedido=1");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
