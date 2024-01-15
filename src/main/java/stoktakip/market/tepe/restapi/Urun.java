package stoktakip.market.tepe.restapi;

public class Urun {
    // Attributes
    private String urunMarkasi;
    private String urunAdi;
    private String urunTuru;
    private String urunMensei;
    private double urunFiyati;
    private int urunStok;

    // Constructor
    public Urun(String urunMarkasi, String urunAdi, String urunTuru, String urunMensei, double urunFiyati, int urunStok) {
        this.urunMarkasi = urunMarkasi;
        this.urunAdi = urunAdi;
        this.urunTuru = urunTuru;
        this.urunMensei = urunMensei;
        this.urunFiyati = urunFiyati;
        this.urunStok = urunStok;
    }

    // Getter - Setters
    public String getUrunMarkasi() {
        return urunMarkasi;
    }

    public void setUrunMarkasi(String urunMarkasi) {
        this.urunMarkasi = urunMarkasi;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUrunTuru() {
        return urunTuru;
    }

    public void setUrunTuru(String urunTuru) {
        this.urunTuru = urunTuru;
    }

    public String getUrunMensei() {
        return urunMensei;
    }

    public void setUrunMensei(String urunMensei) {
        this.urunMensei = urunMensei;
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
