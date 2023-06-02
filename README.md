# Exchange Rate App


<h2>Jsoup ile Merkez Bankası Döviz Kuru Bilgilerini Alma </h2>
<p>Bu projede, Jsoup kullanılarak Merkez bankasından günlük güncel döviz kurlarının bilgileri alınıp kullanıcıya gösterilmektedir. Veriler Jsoup yapısı ile alınmıştır ve her gün güncellenmektedir. Listeden seçilen para biriminin ilgili tüm alış-satış fiyatı ekranda gösterilmektedir. </p>

<h2>Kullanılan Bağımlılıklar</h2>
<pre><code>implementation 'org.jsoup:jsoup:1.16.1'</code></pre>

<h2>Manifest Dosyası</h2>
<pre><code>&lt;uses-permission android:name="android.permission.INTERNET"/&gt;</code></pre>

<h2>Import İşlemleri</h2>
<pre><code>import org.jsoup.Jsoup</code></pre>
<pre><code>import org.jsoup.nodes.Document</code></pre>
<pre><code>import org.jsoup.select.Elements</code></pre>


<h2>Uygulama Ekran Görüntüsü</h2>
<p float="left">
  <img src="https://user-images.githubusercontent.com/100219838/236619757-e41162f2-d201-434b-ae4c-df79148209e6.png" width="30%" />
  <img src="https://user-images.githubusercontent.com/100219838/236619761-de66f86c-2844-4d7b-9c6e-23f6ddd7158b.png" width="30%" />
  <img src="https://user-images.githubusercontent.com/100219838/236619764-6582b52b-c52a-4509-9c54-8c913271c21c.png" width="30%" />
</p>

