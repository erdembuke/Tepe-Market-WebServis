package stoktakip.market.tepe.restapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
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

    // Unit tests for the methods in UrunService class and Urun class

    @Test
    public void testUrunleriListeleUrunService() {
        UrunService urunService1 = new UrunService();
        List<Urun> urunList = urunService1.urunleriListele();
        // Assertion of list size more than 1
        Assertions.assertTrue(urunList.size() > 1);

    }

    @Test
    public void testUrunEkleUrunService() {
        UrunService urunService1 = new UrunService();
        Urun urun = new Urun("01908862", "Mock", "Mock", 20, 150);
        Urun eklenenUrun = urunService1.urunEkle(urun);

        // Assertions
        Assertions.assertEquals("01908862", eklenenUrun.getSeriNo());
        Assertions.assertEquals("Mock", eklenenUrun.getUrunAdi());
        Assertions.assertEquals("Mock", eklenenUrun.getUrunMarka());
        Assertions.assertEquals(20, eklenenUrun.getUrunGramaj());
        Assertions.assertEquals(150, eklenenUrun.getUrunBirimFiyat());
    }

    @Test
    public void testUrunBulUrunService() {
        UrunService urunService1 = new UrunService();
        Urun urun = urunService1.urunBul("908861"); // Ulker Cikolatali Gofret Mock Data

        // Assertions
        Assertions.assertEquals("908861", urun.getSeriNo());
        Assertions.assertEquals("Cikolatali Gofret", urun.getUrunAdi());
        Assertions.assertEquals("Ulker", urun.getUrunMarka());
        Assertions.assertEquals(40, urun.getUrunGramaj());
        Assertions.assertEquals(5.50, urun.getUrunBirimFiyat());
    }

    @Test
    public void testUrunSilUrunService() {
        UrunService urunService1 = new UrunService();
        Urun urun = new Urun("123456789","mock","mock",24,24);
        urunService1.urunEkle(urun);

        boolean deleted = urunService1.urunSil("123456789"); // should be true
        boolean deleted2 = urunService1.urunSil("123456789"); // should be false , deleted already

        // Assertion
        Assertions.assertTrue(deleted);
        Assertions.assertFalse(deleted2);

    }

    @Test
    public void testUrunToString() {
        Urun urun = new Urun("12345","mock","mock",1,1);

        Assertions.assertEquals("Urun{seriNo='12345', urunAdi='mock', urunMarka='mock', urunGramaj=1, urunBirimFiyat=1.0}"
        , urun.toString());
    }

    @Test
    public void testUrunSetMethods() {
        Urun urun = new Urun("123456","mock","mock",1,1);

        // Change values with set methods
        urun.setSeriNo("102030");
        urun.setUrunAdi("modifiedName");
        urun.setUrunMarka("modifiedBrand");
        urun.setUrunGramaj(2);
        urun.setUrunBirimFiyat(2);

        // Assertions
        Assertions.assertEquals("102030", urun.getSeriNo());
        Assertions.assertEquals("modifiedName", urun.getUrunAdi());
        Assertions.assertEquals("modifiedBrand", urun.getUrunMarka());
        Assertions.assertEquals(2, urun.getUrunGramaj());
        Assertions.assertEquals(2, urun.getUrunBirimFiyat());
    }
}