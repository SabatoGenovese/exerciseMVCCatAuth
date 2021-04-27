package model;

public class Prodotto
{
   private int ID;
   private String nome, descrizione;
   private float prezzo;

   public int getID()
   {
      return ID;
   }

   public void setID(int ID)
   {
      this.ID = ID;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public String getDescrizione()
   {
      return descrizione;
   }

   public void setDescrizione(String descrizione)
   {
      this.descrizione = descrizione;
   }

   public float getPrezzo()
   {
      return prezzo;
   }

   public void setPrezzo(float prezzo)
   {
      this.prezzo = prezzo;
   }
}