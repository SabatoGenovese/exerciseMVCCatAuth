package controller;

import model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/CategoriaServlet", loadOnStartup = 1)
public class CategoriaServlet extends HttpServlet
{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      String categoriaID = request.getParameter("categoria");

      if(categoriaID != null)
      {
         List<Prodotto> prodotti = ProdottoDAO.doRetriveById(Integer.parseInt(categoriaID));

         if ((prodotti != null) && (prodotti.size() > 0))
         {
            Categoria categoria = CategoriaDAO.doRetrieveById(Integer.parseInt(categoriaID));

            if (categoria != null)
            {
               request.removeAttribute("categoria");
               request.setAttribute("categoriaBean", categoria);
               request.setAttribute("prodotti", prodotti);

               request.getRequestDispatcher("/WEB-INF/results/categoria.jsp").forward(request, response);
               return;
            }
         }
      }

      response.sendRedirect(request.getServletContext().getContextPath() + "/index.html");
      return;
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