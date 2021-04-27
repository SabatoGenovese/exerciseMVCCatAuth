package controller;

import model.Categoria;
import model.CategoriaDAO;
import model.ConPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;

@WebServlet(name="MyInit", urlPatterns="/MyInit", loadOnStartup = 0)
public class InitServlet extends HttpServlet
{
   @Override
   public void init() throws ServletException
   {
      super.init();
      List<Categoria> categorie = CategoriaDAO.doRetrieveAll();
      getServletContext().setAttribute("categorie", categorie);
   }

   @Override
   public void destroy()
   {
      super.destroy();
      ConPool.deleteConnection();
   }
}