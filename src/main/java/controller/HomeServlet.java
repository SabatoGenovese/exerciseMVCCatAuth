package controller;

import model.ConPool;
import model.ProdottoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns="/index.html")
public class HomeServlet extends HttpServlet
{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      request.setAttribute("prodotti", ProdottoDAO.doRetrieveAll());

      request.getRequestDispatcher("/WEB-INF/results/index.jsp").forward(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException
   {
      doGet(requset, response);
   }

   @Override
   public void destroy()
   {
      super.destroy();
      ConPool.deleteConnection();
   }
}