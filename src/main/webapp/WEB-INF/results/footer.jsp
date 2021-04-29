<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
   <head> </head>
   <body>
      <fieldset>
         <legend>Accedi</legend>
         <form method="post" action="LoginServlet">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
            <input type="submit" value="Accedi">
         </form>
      </fieldset>

      <fieldset>
         <legend>Registrazione</legend>
         <form method="post" action="RegistrazioneServlet">
            <input type="text" placeholder="Username" name="username" required>
            <input type="password" placeholder="Password" name="password" required>
            <input type="email" placeholder="Email" name="email" required>
            <label style="font-style: italic">Amministratore</label>
            <label for="admin">Si</label>
            <input type="radio" id="admin" name="admin" value="1">
            <label for="notAdmin">No</label>
            <input type="radio" id="notAdmin" name="admin" value="0">
            <input type="submit" value="Registrati">
         </form>
      </fieldset>
   </body>
</html>
