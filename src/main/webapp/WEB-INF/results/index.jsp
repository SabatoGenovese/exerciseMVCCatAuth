<%@ page import="java.util.List" %>
<%@ page import="model.Prodotto" %>
<%@ page import="model.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
   <head>
      <title>Inventario Prodotti</title>

      <link rel="stylesheet" href="./css/stile.css" type="text/css">
   </head>
   <body>
      <%@ include file="header.jsp" %>
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
         <form method="post" action="CategoriaServlet">
            <select name="categoria" >
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

            <input type="submit" name="categoriaScelta" value="Filtra Prodotti" formtarget="_blank">
         </form>
      </fieldset>

      <%@ include file="footer.jsp" %>
   </body>
</html>