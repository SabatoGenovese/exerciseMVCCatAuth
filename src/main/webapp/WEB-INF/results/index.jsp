<%@ page import="java.util.List" %>
<%@ page import="model.Prodotto" %>
<%@ page import="model.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
   <head>
      <title>Inventario Prodotti</title>

      <style>
         h1 {
             text-align: center;
         }

         select {
             width: 200px;
             height: 50px;
         }

         table, th, tr, td {
             text-align: center;
             border: 2px solid blue;
             font-family: "Arial";
             font-size: medium;
         }

         th {
             font-size: large;
         }
      </style>
   </head>
   <body>
      <h1> Inventario Prodotti</h1>
      <table>
         <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrizione</th>
            <th>Prezzo</th>
         </tr>

      <% Object obj = request.getAttribute("prodotti");
         if((obj != null) && (obj instanceof List))
         {
            List<Prodotto> prodotti = (List<Prodotto>) obj;

            for(Prodotto p : prodotti)
            {
      %>
            <tr>
               <td><%= p.getID() %></td>
               <td><%= p.getNome() %></td>
               <td><%= p.getDescrizione() %></td>
               <td><%= p.getPrezzo() %></td>
            </tr>
      <%
            }
         }
      %>
      </table>

      <fieldset>
         <legend>Categorie Disponibili</legend>
         <select name="categoria">
            <% obj = request.getServletContext().getAttribute("categorie");
               if((obj != null) && (obj instanceof List))
               {
                  List<Categoria> categorie = (List<Categoria>) obj;

                  for(Categoria c : categorie)
                  {
            %>
            <option value=<%=c.getId()%>><%=c.getNome()%></option>
            <%
                  }
               }
            %>
         </select>
      </fieldset>
   </body>
</html>