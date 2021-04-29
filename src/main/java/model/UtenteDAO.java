package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAO
{
   public static Utente doRetrieveByUsernamePassword(String username, String password)
   {
      try(Connection con = ConPool.getConnection())
      {
         PreparedStatement ps = con.prepareStatement("SELECT ID, username, passwordhash, email, admin FROM utente " +
                                                         "WHERE username=? AND passwordhash=SHA1(?)");
         ps.setString(1, username);
         ps.setString(2, password);

         ResultSet rs = ps.executeQuery();

         if(rs.next())
         {
            Utente utente = new Utente();

            utente.setID(rs.getInt("ID"));
            utente.setUsername(rs.getString("username"));
            utente.setAdmin(rs.getBoolean("admin"));
            utente.setEmail(rs.getString("email"));

            return utente;
         }

         return null;
      }
      catch (SQLException e)
      {
         throw new RuntimeException(e);
      }
   }

   public static void doSave(Utente utente)
   {

   }
}