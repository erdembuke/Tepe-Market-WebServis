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
    void urunleriListele() {
    }

    @Test
    void urunBul() {
    }

    @Test
    void urunEkle() {
    }

    @Test
    void urunSil() {
    }
}