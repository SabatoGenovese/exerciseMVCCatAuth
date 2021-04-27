package model;

public class Categoria
{
   private int id;
   private String nome, descrizione;

   public int getId()
   {
      return id;
   }

   public String getNome()
   {
      return nome;
   }

   public String getDescrizione()
   {
      return descrizione;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public void setDescrizione(String descrizione)
   {
      this.descrizione = descrizione;
   }
}