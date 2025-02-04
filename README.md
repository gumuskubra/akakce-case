# Akakce Test Documentation
1.Manuel Test Case Çalışması

Test Case TC-001: Sayfanın Yüklenmesi
Amaç:
Giriş yapmış kullanıcı için "Takip Listem" sayfasının sorunsuz şekilde yüklenmesini doğrulamak.
Ön Koşul:
Kullanıcı önceden giriş yapmış olmalı.
Adımlar
2.Anasayfa'dan "Person" ikonuna basılır.
3.Takip Listem seçeneği seçilir.
3.Sayfanın tam olarak yüklenmesi beklenir.
Beklenen Sonuç:
1.Sayfa, hatasız şekilde yüklenir; üst menü ve navigasyon öğeleri düzgün görünür.
2.URL'in https://www.akakce.com/akakcem/takip-listem/ şeklinde güncellendiği görülür.
3.Breadcrumb akakcem-Takip Listem şeklindedir.
4.Takip Ettiklerim,Listelerim,Bildirimlerim seçeneklerinin başlık şeklinde geldiği görülür.
5."Takip Et nedir" açıklamasının geldiği görülür.


Test Case TC-002: Boş Takip Listesi Mesajı
Amaç:
Takip listesi boş olduğunda sayfanın bilgilendirici mesaj gösterdiğini doğrulamak.
Ön Koşul: Takip Listesine hiç ürün eklenmemiş veya eklenen ürünlerin kaldırılması gerekmektedir.
Adımlar:
1.Takip listesindeki tüm ilan/ürünleri kaldırın veya yeni hesap açmış bir kullanıcı ile giriş yapılır.
2.Anasayfa'dan "Person" ikonuna basılır.
3.Takip Listem seçeneği seçilir.
Beklenen Sonuç:
1."Takip listeniz şu anda boş!" bilgilendirici mesajı görüntülenir.
2.Milyonlarca ürün arasından "Takip Et" ile listenizi oluşturmaya hemen başlayabilirsiniz.
3.Ana sayfa'ya dön seçeneği bulunur ve üzerine gelindiğinde tıklanabilir olduğu görülür.

Test Case TC-003: Ürün Ekleme
Amaç:
Takip listesinde yapılan ekleme işlemlerinin, sayfa yenilemesi sonrası doğru şekilde güncellendiğini doğrulamak.
Ön Koşul:
Kullanıcı önceden giriş yapmış olmalı.
Adımlar:
2.Anasayfa'dan "Person" ikonuna basılır.
3.Takip Listem seçeneği seçilir.
4.Anasayfaya git'e tıklanır.(Anasayfadan direkt ürün detayına gidilebilir.)
5.Ürünlerden birinin detayına gidilir.
6.Takip et butonuna tıklanır.
7.Takip Listenize eklendi bilgisi görülür.
8.Butonun adının Takibi bırak olarak değiştiği görülür.
9.Takip listem'e gidilir ve ürün detaylarıyla kontrol edilir.(Açık bir Takip Listem sekmesi varsa refresh edilir)
Beklenen Sonuç:
Yapılan ekleme işlemi, sayfa yenilemesi sonrası doğru şekilde yansıtılır.(Database kontrolü de yapılmalıdır.)



Test Case TC-004:Ürün Bilgilerinin Doğru Gelmesi
Amaç:Takip listesinde yer alan her bir ürün gerekli bilgilerini (başlık, fiyat, görsel, açıklama vb.) doğru şekilde görüntülediğini doğrulamak.
Ön Koşul :
En az bir ürün eklenmiş olmalı.
Adımlar:
1.Takip Listem sayfasını açılır.
2.Her ilan kartındaki bilgileri (başlık, fiyat, görsel, açıklama) kontrol edilir.
Beklenen Sonuç:
Gerekli bilgileri doğru ve eksiksiz şekilde gösterildiğini görmek.

Test Case TC-003: Ürün Kaldırılması
Amaç:Kullanıcının takip listesinden bir ürünü kaldırma işleminin sorunsuz çalıştığını doğrulamak.
Ön Koşul:
Takip listesinde en az bir ürün mevcut olmalı.
Adımlar:
1.Takip listesinden "Düzenle" butonuna tıklanır
2.Açılan "Tüm Ürünler"pop-upında ilgili ürünün checkboxı işaretlenir.
3."Takibi Bırak"butonuna tıklanır.
4.Açılan onay penceresinde işlemi onaylanır.
Beklenen Sonuç:
Seçilen ürünün kaldırıldığı görülür.


Test Case TC-005: Takip listesine çok ürün eklendiğinde işlevselliğinin kontrolü

Amaç:
Çok sayıda (örneğin, 20 veya daha fazla) ürün bulunduğunda, kaydırma işlevselliğinin doğru çalıştığını doğrulamak.
Adımlar:
1.Takip listesine birden fazla ürün eklenir.
Beklenen Sonuç:
Ürünler sorunsuz şekilde yüklenir; sayfalama veya sonsuz kaydırma işlevselliği düzgün çalışır.ve scroll özelliği doğru çalışır.


Test Case TC-006: Sayfa Yenileme ve Güncelleme
Ön Koşul:
Kullanıcı önceden giriş yapmış olmalı.
Amaç:
Takip listesinde yapılan ekleme veya silme işlemlerinin, sayfa yenilemesi sonrası doğru şekilde güncellendiğini doğrulamak.
Adımlar:
1.Takip listesinde bir ürün eklenir.
2.Sayfayı yenienir(refresh).
Beklenen Sonuç:
Yapılan ekleme/silme işlemi, sayfa yenilemesi sonrası doğru şekilde yansıtılır.


Test Case TC-007: Mobil ve Tarayıcı Uyumluluk Testleri (Responsive Test)
Amaç:
Takip Listem sayfasının farklı cihazlar (mobil, tablet, masaüstü) ve tarayıcılarda uyumlu şekilde görüntülendiğini doğrulamak.
Ön Koşul / Notlar:
Farklı cihaz/tarayıcı test ortamı gereklidir.
Adımlar:
1.Sayfayı farklı cihazlarda (örneğin, mobil, tablet, masaüstü) ve farklı tarayıcılarda açılır.
2.UI öğelerinin yerleşimini ve fonksiyonelliğini kontrol edin.
Beklenen Sonuç:
Sayfa, tüm cihaz ve tarayıcılarda uyumlu (responsive) olarak görüntülenir; tüm fonksiyonlar sorunsuz çalışır.



Test Case TC-008: Arama İşlevselliğinin Doğrulanması
Amaç:
Takip listesinde yer alan ürünler arasında arama yapıldığında, ilgili sonuçların doğru şekilde görüntülendiğini doğrulamak.
Ön Koşul:
Sayfada arama işlevi aktif olmalı ve ürünler aranacak anahtar kelimeyi içermelidir.
Adımlar:
1.Takip Listem sayfasını açılır.
2.Arama kutusuna belirli bir anahtar kelime girilir.(ürünlerin içermediği datalarla da denenmelidir.)
3.Arama butonuna tıklanır.
Beklenen Sonuç:
Arama sonuçları, girilen anahtar kelime ile eşleşmelive  sonuçlar doğru  bir şekilde listelenmiş olmalıdır.



Test Case TC-009: Sıralama İşlevselliğinin Doğrulanması

Amaç:
Takip listesindeki ürünlerin belirli kriterlere göre sıralandığını doğrulamak.
Adımlar:
1.Takip Listem sayfası açılır.
2.Sıralama seçeneklerinden (örneğin "Fiyata Göre Azalan") biri seçilir.
3.En çok fiyattan en aza doğru sıralandığı görülür.
4.Ekleme Tarihi,En Düşük Fiyat,En Yüksek Fiyat ,Kategori ve Ürün adı'na göre filrelemeler yapılır.
Beklenen Sonuç:
Ürünlerin seçilen sıralama kriterine uygun olarak doğru sırayla listelenmesi gereklidir.



Test Case TC-010: Güvenlik ve Erişim Kontrolleri
Amaç:
Giriş yapmamış veya yetkilendirilmemiş kullanıcıların "Takip Listem" sayfasına erişiminin engellendiğini doğrulamak.
Adımlar:
Çıkış yapmış bir tarayıcı veya gizli mod (incognito) kullanarak sayfaya erişilir.
Beklenen Sonuç:
Kullanıcı, giriş yapması gerektiğine dair uyarı alır veya giriş sayfasına yönlendirilir; içerik görüntülenmez.
Ön Koşul / Notlar:
Yetkilendirme mekanizmaları doğru çalışmalıdır.

