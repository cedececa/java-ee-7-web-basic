/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClienteFacade;
import dao.PedidoFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Pedido;
import entity.Cliente;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Cheng
 */
@WebServlet(name = "Carrito", urlPatterns = {"/Carrito"})
public class Carrito extends HttpServlet {

    @EJB
    PedidoFacade pedidoFacade;
    @EJB
    ClienteFacade clienteFacade;

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
        //response.setContentType("text/html;charset=UTF-8");

        // caso solo idpedido
        String idpedido = request.getParameter("idpedido");
        String idcliente = request.getParameter("idcliente");
        Pedido pedidoEncontrado = pedidoFacade.findById(idpedido);
        
        /**
         * caso: idpedido y idcliente si no existe un pedido con ese id, se
         * debera crear uno nuevo para ese cliente.
         */
        if (pedidoEncontrado == null) {
            Cliente cliente = this.clienteFacade.find(Integer.parseInt(idcliente));
            pedidoEncontrado = new Pedido();
            
            // NO SE PERMITE MODIFICAR ID PORQUE CLAVE PRIMARIA DE LA TABLA ES AUTOGENERADA.
            // pedidoEncontrado.setPedidoId(Integer.parseInt(idpedido));

            pedidoEncontrado.setClienteId(cliente);
            cliente.getPedidoList().add(pedidoEncontrado);
            this.pedidoFacade.create(pedidoEncontrado);
        }

        // set las variables para la pagina jsp
        request.setAttribute("idpedido", idpedido);
        request.setAttribute("pedidoEncontrado", pedidoEncontrado);

        // se le pasa el control a la JSP “pagina.jsp”
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("carrito.jsp");
        rd.forward(request, response);

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
