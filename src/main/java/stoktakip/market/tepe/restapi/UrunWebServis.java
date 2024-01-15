package stoktakip.market.tepe.restapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/urun")
public class UrunWebServis {

    private static final List<Urun> URUN_LIST = new ArrayList<>();

    // kontrol kolayligi icin statik olarak api'ye birkac mock veri girisi yapilmasi
    static {
        URUN_LIST.add(new Urun("Ulker","Cikolatali Gofret","Gida","Turkiye",
                5,356));
        URUN_LIST.add(new Urun("Nuh Ankara","Cubuk Makarna","Gida","Turkiye",
        10,550));
        URUN_LIST.add(new Urun("Vancouver Magic","Yaban Mersini","Meyve","Kanada",
                150,20));
        URUN_LIST.add(new Urun("Akdeniz Manav","Sikma Portakal","Meyve","Turkiye",
                3,210));
        URUN_LIST.add(new Urun("Sebze Dunyasi","Kabak","Sebze","Turkiye",
                10,77));
    }
}
