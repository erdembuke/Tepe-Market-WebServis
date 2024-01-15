package stoktakip.market.tepe.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class UrunWebServisTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrunService urunService;

    @Test
    void test_urunleri_listele() throws Exception{
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
    void test_urun_bul() throws Exception {
        when(urunService.urunBul("908861"))
                .thenReturn(
                        new Urun("908861","Cikolatali Gofret","Ulker",40,5.5)
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
    void test_urun_ekle() {
    }

    @Test
    void test_urun_sil() {
    }
}