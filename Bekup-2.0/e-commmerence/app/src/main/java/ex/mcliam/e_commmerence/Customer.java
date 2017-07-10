package ex.mcliam.e_commmerence;

/**
 * Created by McLiam on 11/6/2016.
 */

public class Customer {

    private String nama;
    private String harga;
    private String penjual;

    public Customer(String nama, String harga, String penjual){
        this.harga = nama;
        this.nama = harga;
        this.penjual = penjual;
    }

    public String getNama(){
        return nama;
    }

    public String setNama(String nama){
        this.nama = nama;
    }

    public String getHarga(){
        return harga;
    }

    public String setHarga(String harga){
        this.harga = harga;
    }

    public String getPenjual(){
        return penjual;
    }

    public String setPenjual(String penjual){
        this.penjual = penjual;
    }

}
