package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO
{
   public static List<Prodotto> doRetrieveAll()
   {
      try(Connection con = ConPool.getConnection())
      {
         PreparedStatement ps = con.prepareStatement("SELECT ID, nome, descrizione, prezzo FROM prodotto");
         List<Prodotto> prodotti = new ArrayList<>();
         ResultSet rs = ps.executeQuery();

         while(rs.next())
         {
            Prodotto prodotto = new Prodotto();
            prodotto.setID(rs.getInt("ID"));
            prodotto.setNome(rs.getString("nome"));
            prodotto.setDescrizione(rs.getString("descrizione"));
            prodotto.setPrezzo(rs.getFloat("prezzo"));
            prodotti.add(prodotto);
         }

         return prodotti;
      }
      catch (SQLException e)
      {
         throw new RuntimeException(e);
      }
   }
}