<%@ page import="java.util.List" %>
<%@ page import="model.Prodotto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
   <head>
      <title>${categoriaBean.nome}</title>

      <link rel="stylesheet" href="./css/stile.css" type="text/css">
   </head>
   <body>
      <jsp:include page="header.jsp"></jsp:include>

      <h1>${categoriaBean.nome}</h1>
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
   </body>
</html>