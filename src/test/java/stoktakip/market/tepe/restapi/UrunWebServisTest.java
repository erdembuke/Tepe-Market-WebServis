package stoktakip.market.tepe.restapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class UrunWebServisTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrunService urunService;

    private static final List<Urun> urunList = new ArrayList<>();

    // API Unit Tests
    @Test
    void testUrunleriListele() throws Exception {
        when(urunService.urunleriListele())
                .thenReturn(List.of(
                        // we expect mock datas we put as static list in UrunService.class
                        new Urun("908861", "Cikolatali Gofret", "Ulker", 40, 5.50),
                        new Urun("908862", "Kelebek Makarna", "Nuh Ankara", 500, 10.75)
                ));

        mockMvc.perform(get("/urun/"))
                .andExpect(status().isOk())
                // also here we expect mock datas we put as static list in UrunService.class
                .andExpect(content().json("[{\"seriNo\":\"908861\",\"urunAdi\":\"Cikolatali Gofret\"," +
                        "\"urunMarka\":\"Ulker\",\"urunGramaj\":40,\"urunBirimFiyat\":5.5},{\"seriNo\":\"908862\"," +
                        "\"urunAdi\":\"Kelebek Makarna\",\"urunMarka\":\"Nuh Ankara\",\"urunGramaj\":500," +
                        "\"urunBirimFiyat\":10.75}]"));
        // Got the values from Postman Get call with raw json and copy-pasted here
    }

    @Test
    void testUrunBul() throws Exception {
        when(urunService.urunBul("908861"))
                .thenReturn(
                        new Urun("908861", "Cikolatali Gofret", "Ulker", 40, 5.5)
                );

        mockMvc.perform(get("/urun/908861"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.seriNo").value("908861"))
                .andExpect(jsonPath("$.urunAdi").value("Cikolatali Gofret"))
                .andExpect(jsonPath("$.urunMarka").value("Ulker"))
                .andExpect(jsonPath("$.urunGramaj").value(40))
                .andExpect(jsonPath("$.urunBirimFiyat").value(5.50));
    }

    @Test
    void testUrunEkle() throws Exception {
        Urun urun = new Urun("9088621", "Mock Product", "Mock Brand", 250,
                147.26);

        // any yazmadan response bos geldigi icin any matcher ile sorunu cozdum
        when(urunService.urunEkle(any(Urun.class)))
                .thenReturn(urun);

        mockMvc.perform(post("/urun/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"seriNo\":\"9088621\",\"urunAdi\":\"Mock Product\",\"urunMarka\":\"Mock Brand\"," +
                                "\"urunGramaj\":250,\"urunBirimFiyat\":147.26}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.seriNo").value("9088621"))
                .andExpect(jsonPath("$.urunAdi").value("Mock Product"))
                .andExpect(jsonPath("$.urunMarka").value("Mock Brand"))
                .andExpect(jsonPath("$.urunGramaj").value(250))
                .andExpect(jsonPath("$.urunBirimFiyat").value(147.26));
    }

    @Test
    void testUrunSil() throws Exception {
        when(urunService.urunSil("908861"))
                .thenReturn(true);

        mockMvc.perform(delete("/urun/908861"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

    }

    // Other Unit tests

    @Test
    public void testUrunleriListele2() {
        UrunService urunService1 = new UrunService();
        List<Urun> urunList = urunService1.urunleriListele();
        String list = urunList.toString();
        Assertions.assertEquals("[Urun{seriNo='908861', urunAdi='Cikolatali Gofret', urunMarka='Ulker', urunGramaj=40," +
                " urunBirimFiyat=5.5}, Urun{seriNo='908862', urunAdi='Kelebek Makarna', urunMarka='Nuh Ankara', urunGramaj=500," +
                " urunBirimFiyat=10.75}]", list);
        // Assertion of Brings all mock datas


    }

    @Test
    public void testUrunEkle2() {
        UrunService urunService1 = new UrunService();
        Urun urun = new Urun("01908862", "Mock", "Mock", 20, 150);
        Urun eklenenUrun = urunService1.urunEkle(urun);

        Assertions.assertEquals("01908862", eklenenUrun.getSeriNo());
        Assertions.assertEquals("Mock", eklenenUrun.getUrunAdi());
        Assertions.assertEquals("Mock", eklenenUrun.getUrunMarka());
        Assertions.assertEquals(20, eklenenUrun.getUrunGramaj());
        Assertions.assertEquals(150, eklenenUrun.getUrunBirimFiyat());
    }
}