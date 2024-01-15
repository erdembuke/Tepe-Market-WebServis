package stoktakip.market.tepe.restapi;

public class Urun {
    private String urunadi;
    private String urunTuru;
    private double urunFiyati;
    private int urunStok;

    public Urun(String urunadi, String urunTuru, double urunFiyati, int urunStok) {
        this.urunadi = urunadi;
        this.urunTuru = urunTuru;
        this.urunFiyati = urunFiyati;
        this.urunStok = urunStok;
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        this.urunadi = urunadi;
    }

    public String getUrunTuru() {
        return urunTuru;
    }

    public void setUrunTuru(String urunTuru) {
        this.urunTuru = urunTuru;
    }

    public double getUrunFiyati() {
        return urunFiyati;
    }

    public void setUrunFiyati(double urunFiyati) {
        this.urunFiyati = urunFiyati;
    }

    public int getUrunStok() {
        return urunStok;
    }

    public void setUrunStok(int urunStok) {
        this.urunStok = urunStok;
    }
}
