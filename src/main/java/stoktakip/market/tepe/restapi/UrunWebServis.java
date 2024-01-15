package stoktakip.market.tepe.restapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/urun")
public class UrunWebServis {

    private static final List<Urun> URUN_LIST = new ArrayList<>();

    // kontrol kolayligi icin statik olarak api'ye birkac mock veri girisi yapilmasi
    static {
        URUN_LIST.add(new Urun("908861","Cikolatali Gofret","Ulker",40,
                5));
        URUN_LIST.add(new Urun("908862","Kelebek Makarna","Nuh Ankara",500,
                10));
        URUN_LIST.add(new Urun("908863","Yaban Mersini","Vancouver Magic",125,
                200));
        URUN_LIST.add(new Urun("908864","Armut","Akdeniz Meyve",1000,45));
        URUN_LIST.add(new Urun("908865","Kabak","Veggie World",1000,37));
    }

    @GetMapping("/")
    public List<Urun> urunleriListele() {
        return URUN_LIST;
    }

    @GetMapping("/{seriNo}")
    public Urun urunBul(@PathVariable String seriNo) {
        for (Urun urun : URUN_LIST) {
            if (urun.getSeriNo().equals(seriNo)) {
                return urun;
            }
        }
        return null;
    }

    @PostMapping("/")
    public Urun urunEkle(@RequestBody Urun urun) {
        URUN_LIST.add(urun);
        return urun;
    }
}
