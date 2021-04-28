<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head> </head>
  <body>
    <fieldset>
      <legend>Accedi</legend>
      <form>
        <label for="username">Username</label>
        <input type="text" id="username" required>
        <label for="password">Password</label>
        <input type="password" id="password" required>
        <input type="submit" value="Accedi">
      </form>
    </fieldset>

    <fieldset>
      <legend>Registrazione</legend>
      <form>
        <input type="text" placeholder="Nome" required>
        <input type="text" placeholder="Username" required>
        <input type="password" placeholder="Password" required>
        <input type="email" placeholder="Email" required>
        <label>Amministratore</label>
        <label for="admin">Si</label>
        <input type="radio" id="admin" name="admin">
        <label for="notAdmin">No</label>
        <input type="radio" id="notAdmin" name="admin">
        <input type="submit" value="Registrati">
      </form>
    </fieldset>
  </body>
</html>
