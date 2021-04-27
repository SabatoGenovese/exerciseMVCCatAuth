package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO
{
   public static List<Categoria> doRetrieveAll()
   {
      try(Connection con = ConPool.getConnection())
      {
         PreparedStatement ps = con.prepareStatement("SELECT ID, nome, descrizione FROM categoria");
         List<Categoria> categorie = new ArrayList<>();
         ResultSet rs = ps.executeQuery();

         while(rs.next())
         {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("ID"));
            categoria.setNome(rs.getString("nome"));
            categoria.setDescrizione(rs.getString("descrizione"));
            categorie.add(categoria);
         }

         return categorie;
      }
      catch (SQLException e)
      {
         throw new RuntimeException(e);
      }
   }
}