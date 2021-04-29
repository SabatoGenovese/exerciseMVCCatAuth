package controller;

import model.ConPool;
import model.ProdottoDAO;
import model.Utente;
import model.UtenteDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet
{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      String username = request.getParameter("username");
      String password = request.getParameter("password");

      if((username != null) && (password != null))
      {
         Utente utente = new UtenteDAO().doRetrieveByUsernamePassword(username, password);

         request.getSession().invalidate();

         request.getSession(true).setAttribute("utente", utente);
      }

      response.sendRedirect(request.getServletContext().getContextPath() + "/index.html");
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