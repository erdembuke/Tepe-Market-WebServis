package stoktakip.market.tepe.restapi;

public class Urun {
    // Attributes
    private String seriNo;
    private String urunAdi;
    private String urunMarka;
    private int urunGramaj;
    private double urunBirimFiyat;

    // Constructor

    public Urun(String seriNo, String urunAdi, String urunMarka, int urunGramaj, double urunBirimFiyat) {
        this.seriNo = seriNo;
        this.urunAdi = urunAdi;
        this.urunMarka = urunMarka;
        this.urunGramaj = urunGramaj;
        this.urunBirimFiyat = urunBirimFiyat;
    }

    // Getter - Setters


    public String getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(String seriNo) {
        this.seriNo = seriNo;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUrunMarka() {
        return urunMarka;
    }

    public void setUrunMarka(String urunMarka) {
        this.urunMarka = urunMarka;
    }

    public int getUrunGramaj() {
        return urunGramaj;
    }

    public void setUrunGramaj(int urunGramaj) {
        this.urunGramaj = urunGramaj;
    }

    public double getUrunBirimFiyat() {
        return urunBirimFiyat;
    }

    public void setUrunBirimFiyat(double urunBirimFiyat) {
        this.urunBirimFiyat = urunBirimFiyat;
    }
}
