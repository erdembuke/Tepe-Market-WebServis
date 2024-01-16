package stoktakip.market.tepe.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// server.port = 8082
@RestController
@RequestMapping("/urun")
public class UrunWebServis {

    @Autowired
    private UrunService urunService;

    @GetMapping("/")
    public List<Urun> urunleriListele() {
        return urunService.urunleriListele();
    }

    @GetMapping("/{seriNo}")
    public Urun urunBul(@PathVariable String seriNo) {
        return urunService.urunBul(seriNo);
    }

    @PostMapping("/")
    public Urun urunEkle(@RequestBody Urun urun) {
        return urunService.urunEkle(urun);
    }

    @DeleteMapping("/{seriNo}")
    public boolean urunSil(@PathVariable String seriNo) {
        return urunService.urunSil(seriNo);
    }
}
