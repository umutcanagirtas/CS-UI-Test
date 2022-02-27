# CS-UI-Test


Selenium, allure ve Log4j framework kullanarak birkaç senaryo üzerinden UI Test projesi oluşturdum. Test sonuçlarının raporlanması için Log4j, monitoring edilmesi için de allure yapısını kullandım. Bu proje Web Sitesinin(Mizu) girilen parametrelere login kontrollerinin yapıldığı ve bunların yönetilmesini sağlayan monitoring logging yardımıyla çok amaçlı olarak isteğe göre değiştirilebilir bir projedir.

## Kullanılan Teknolojiler

- Java (Projenin yazılmış olduğu kodlama dilidir);
- TestNG(Test Caselerin yazılması ve çıktıların kontrollerinde kullanılan Test Yazım Aracıdır);
- Selenium (Web Sitesini test etmek için kullanılan Test Otomasyon Aracıdır);
- Allure (Test Sonuclarının monitorize edilmesini sağlar);
- Log4J (Hata sonuçlarının loglanmasını sağlar);
- Page Object Pattern (Projede kullanılan mimari yapıdır).

## Proje Yapısının Açıklanması

Projede aşşağıda açıkladığım yapıyı kullandım;

![image](https://user-images.githubusercontent.com/56224909/155900864-58b3616a-5bfd-4b13-8a95-5d39b64ea4b7.png)

+ **Base:** BaseClass, BasePage ve Constants sınıflarının bulunduğu klasör.
  + **BaseClass** Bu sınıf içerisinde driverı ayağa kaldırma, ilk url girme ve driver sonlandırma işlemleri yapıldı.
  + **BasePage** Bu sınıf driverları ortak bir sınıfa bağlıyor.
  + **Constants** Bu sınıf içerisinde projede kullanılan sabit değişkenler tanımlandı.

![image](https://user-images.githubusercontent.com/56224909/155901065-5209be7f-cbe4-46bb-a763-e9ccb531fa66.png)

+ **Helpers** Sistemde birden fazla yerde kullanılacağını düşündüğüm metodları bu klasör altında topladım. Böylelikle kod tekrarını önleyip okunaklığı arttırabileceğini düşündüm. Helpers klasörü altında; ActionClass, CustomElementWaits, DataHelpers, DataProvider, Listeners ve Log sınıfları bulunur.
  + **ActionClass:** Sayfa aksiyonlarının artması durumunda(moveTo gibi) işimizi kolaylaştırabilecek bir yapıdır. Şuanki tek amacı elementleri görünür olana dek sayfayı harekeket ettirmektir.
  + **CustomElementWaits:** Sayfa Yüklenirken geç gelen elementleri beklememizi kolaylaştıran bir sınıftır(clickable, visibility ve findall gibi).
  + **DataHelpers:** Listelerden random bir şekilde eleman çekmemize yarayan bir sınıftır.
  + **DataProvider** Testng ile gelen bir özellik olan @dataprovider özelliğini kullanabilmek için yaratılan bir sınıftır. Tanımlanan testleri verilen parametreler ile birlikte çalıştırır.
  + **Listeners:** Projede bulunan caseleri dinleyen bir yapıdır.
  + **Log:** Loglama yapmamızı sağlayan bir yapıdır.

![image](https://user-images.githubusercontent.com/56224909/155901365-5b5d823b-932d-4fe4-b1e7-eb6462e73feb.png)

+ **Pages:** Pages klasörünün yaratılma sebebi Pape Object Pattern kalıbını uygulamaktır. İçerisinde caselerde kullanılan tüm sayfalar sınıflar aracılığıyla temsil edilir. Pages Klasörü içerisinde; Facebook login sayfası, Google login sayfaları, Mizu Login sayfası, Ana sayfa ve PopUp alanı sınıfları bulunur.
  + **FacebookLoginPage** Login ekranında "Sing in with Facebook" butonuna tıklandığında açılan sayfadır. Açılan sayfada Facebook girişi gerçekleştirilir.
  + **GoogleUserNamePage ve GoogleUserPasswordPage** Login ekranındaN "Sign in with Google" butonuna tıklandığında açılan sayfadır. Açılan sayfalarda Google hesap girişi gerçekleştirilir.
  + **LoginPage** Üye giriş sayfasıdır.
  + **PopUpLoginPage** Login sayfası üzerinde hatalı giriş olduğunda çıkan Popup'u içeriyor.
  + **MainPage** Kullanıcıyı karşılayan Ana Sayfadır(mizu.com). Login için ilk hareket işlemleri bu sayfa üzerinden yapılır.

![image](https://user-images.githubusercontent.com/56224909/155901930-a4f6ff9b-96be-4f7b-b245-73a914a10fe4.png)

+ **Retry** Bu klasör içerisinde RetryAnalyzer sınıfı bulunmaktadır. Bu sınıf testler sırasında hata alan testleri bizim verdiğimiz parametrele göre yeniden çalıştırır.

![image](https://user-images.githubusercontent.com/56224909/155901972-a6677ad2-6b0d-4326-bf34-efa7c704aa5b.png)

+ **tests** Test Caselerimizin bulunduğu klasördür.
  **loginPageTestCases** İçerisinde Login sınıfında gerçekleşecek test caseler bulunur.
  
![image](https://user-images.githubusercontent.com/56224909/155902026-ba430ae3-d50f-4cae-be15-ad3b1a5be437.png)

+ **resources** Properties dosyları ve testng.xml dosyları bulunur.
  + **allure.properties** allure kayıtlarını yönlendiren sınıftır.
  + **log4j.properties** log4j kullanarak log dosyası oluşturma standartlarını ayarladığımız sınıftır.
  + **testng.xml** testlerin koşumunu sağlayan bir xml dosyası.

## Projenin Ayağa Kaldırılması

1. İlk olarak projede bulunan constants sınıfı içerisinde değişiklik yapılmalıdır. Değişken değerleri değiştirilmeliki proje de kendi login işlemlerinizigerçekleştirebilesiniz. log4j.properties ve allure.properties dosyalarında kendi pathlerinizi ayarlayabilirsiniz.
2. BaseClass içerisinde driver kaldırma sırasında bilgisayarınızda ki driver pathlerini vermemiz gerekir.
3. Allure monitoring kullanmak isterseniz de bilgisayarınızda allure'nin yüklü olması gerekiyor.

## Allure Monitoring Kullanımı

Allure yapısı caseler her tamamlandıktan sonra belirtilen path e kaydediliyor. Bunları görüntülemek için komut satırını açıp "allure serve [config dosyasında ayarladığınız path]\allure-results" girerseniz browserda açılan pencere üzerinde detaylı inceleme yapabilirsiniz.

![image](https://user-images.githubusercontent.com/56224909/155902464-cb46fc0a-4993-4cb8-a781-934b9c469585.png)

## Örnek Ekran Çıktıları

- Log Yapısının Örnek çıktısı:

![image](https://user-images.githubusercontent.com/56224909/155902513-940a0e06-0681-4704-ba4f-472b379e60a0.png)

- Allure Ekran Görüntüsü

![image](https://user-images.githubusercontent.com/56224909/155902605-ad26321c-8b8f-45f6-9a27-1f1cc5c0406f.png)
