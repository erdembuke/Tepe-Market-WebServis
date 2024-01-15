package stoktakip.market.tepe.restapi;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UrunService {

    private static final List<Urun> URUN_LIST = new ArrayList<>();

    public UrunService() {

        URUN_LIST.add(new Urun("908861", "Cikolatali Gofret", "Ulker", 40, 5.50));
        URUN_LIST.add(new Urun("908862", "Kelebek Makarna", "Nuh Ankara", 500, 10.75));

    }

    public List<Urun> urunleriListele() {
        return URUN_LIST;
    }

    public Urun urunBul(String seriNo) {
        for (Urun urun : URUN_LIST) {
            if (urun.getSeriNo().equals(seriNo)) {
                return urun;
            }
        }
        return null;
    }

    public Urun urunEkle(Urun urun) {
        URUN_LIST.add(urun);
        return urun;
    }

    public boolean urunSil(String seriNo) {
        Urun urun = urunBul(seriNo);
        if (urun != null) {
            URUN_LIST.remove(urun);
            return true;
        }
        return false;
    }
}
