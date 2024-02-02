# Tepe Market Stok Takip Sistemi

Bu proje, "Yazılım Geliştirme Ortam ve Araçları" dersinin final projesi için geliştirilmiştir. "Tepe Market" isimli (sahte isimlendirme) marketin stok takip sisteminin arayüzünü (API) Java dilinde ve Spring teknolojileri kullanılarak kodlanmıştır. Proje ayrıca kodların birim testleri, Postman ve JMeter üzerinde yapılan testleri içermektedir.

## Teknolojiler

- Java 17 
- Spring Boot 3.2.1
- JaCoCo 0.8.8 (Code Coverage)

## Sınıflar

1. **StokTakipRestApiApplication:** API'nin çalıştırılması için kullanılan sınıf.
2. **Urun:** Ürün özelliklerini içeren sınıf (isim, marka, fiyat vb.).
3. **UrunService:** API metodlarının kodlarını içeren `@Service` sınıfı.
4. **UrunWebServis:** API metodlarını içeren `@RestController` sınıfı.
5. **UrunWebServisTest:** Projenin birim testlerini içeren sınıf (%97 kod kapsamı).

## API endpointler

1. **GET /urun/:** Butun urunleri listelemek için kullanılan method
2. **GET /urun/{seriNo}:** Seri numarasi ile bulunan ürünün bilgilerini listelemek için kullanılan method
3. **POST /urun/:** Sisteme ürün eklemek için kullanılan method
4. **DELETE /urun/{seriNo}:** Seri numarası ile sistemden ürün silmek için kullanılan method

## API Kullanımı

Postman veya JMeter gibi bir API test aracı kullanın.
API endpoint'lerine HTTP istekleri gönderin.
JSON formatında veri alın ve gönderin.   

## Testler

1. Birim Testler (%97 Code Coverage)
2. Postman ve JMeter ile API testleri

## Dökümantasyon

Repository'de "Tepe-Market.pdf" adında detaylı teknik rapor bulunmaktadır

## Kurulum

1. Projeyi klonlayın (IDE veya Terminal kullanarak)
2. StokTakipRestApiApplication class yardımıyla veya maven kullanarak projeyi çalıştırın.




