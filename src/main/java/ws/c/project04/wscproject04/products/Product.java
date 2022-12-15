/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.c.project04.wscproject04.products;

/**
 *
 * @author STRIX
 */
public class Product {
    private String id;
    private String name;
    private String harga;
    private String jumlah;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String  getHarga(){
       return harga;
   }
   
   public void setHarga(String harga) {
      this.harga = harga;
   }
   
   public String getJumlah(){
       return jumlah;
   }
   
   public void setJumlah(String Jumlah) {
      this.jumlah = Jumlah;
   }
}
