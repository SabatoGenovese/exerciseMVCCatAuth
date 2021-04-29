package model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utente
{
   private int ID;
   private String email, username, passwordHash;
   private boolean admin;

   public void setPasswordHash(String password)
   {
      try
      {
         MessageDigest digest = MessageDigest.getInstance("SHA-1");
         digest.reset();
         digest.update(password.getBytes(StandardCharsets.UTF_8));
         this.passwordHash = String.format("%040x", new BigInteger(1, digest.digest()));
      }
      catch (NoSuchAlgorithmException e)
      {
         throw new RuntimeException(e);
      }
   }

   public boolean isAdmin()
   {
      return admin;
   }

   public void setAdmin(boolean admin)
   {
      this.admin = admin;
   }

   public int getID()
   {
      return ID;
   }

   public void setID(int ID)
   {
      this.ID = ID;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getUsername()
   {
      return username;
   }

   public void setUsername(String username)
   {
      this.username = username;
   }

   public String getPasswordHash()
   {
      return passwordHash;
   }

   public void setPassword(String password)
   {
      setPasswordHash(password);
   }
}