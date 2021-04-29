package controller;

import model.ConPool;
import model.Utente;
import model.UtenteDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet
{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      String email = request.getParameter("email");
      boolean admin = request.getParameter("admin").equalsIgnoreCase("1");

      if(username != null && password != null && email != null)
      {
         Utente utente = new Utente();
         utente.setUsername(username);
         utente.setPassword(password);
         utente.setEmail(email);
         utente.setAdmin(admin);

         if(UtenteDAO.doSave(utente) == 1)
         {
            request.getSession().invalidate();
            request.getSession(true).setAttribute("utente", utente);
         }
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