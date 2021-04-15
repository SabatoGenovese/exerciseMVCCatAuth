package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name="MyInit", urlPatterns="/MyInit", loadOnStartup=0)
public class InitServlet extends HttpServlet
{
   @Override
   public void init() throws ServletException
   {
      super.init();
      /*CategoriaDAO categoriaDAO = new CategoriaDAO();
      List<Categoria> categorie = categoriaDAO.doRetrieveAll();
      getServletContext().setAttribute("categorie", categorie);
   */}
}