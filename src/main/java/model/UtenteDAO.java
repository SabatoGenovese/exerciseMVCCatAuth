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

   public static int doSave(Utente utente)
   {
      if(utente != null)
         try(Connection con = ConPool.getConnection())
         {
            PreparedStatement ps = con.prepareStatement("INSERT INTO utente (username, passwordhash, email, admin) VALUES (?, ?, ?, ?)");
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getPasswordHash());
            ps.setString(3, utente.getEmail());
            ps.setBoolean(4, utente.isAdmin());

            return ps.executeUpdate();
         }
         catch (SQLException e)
         {
            throw new RuntimeException(e);
         }

      return 0;
   }
}