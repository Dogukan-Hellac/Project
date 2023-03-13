package com.example.isimsehiroyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class SureliOyunActivity extends AppCompatActivity {

    private CountDownTimer countDownTimer;
    private Button btnHarfAl, btnTahminEt, btnPasGec;


    private TextView txtIlBilgi, txtIlHarfSayisi, txtPuan, txtTime, txtInfo;
    private EditText editTxtTahminGiriniz;
    private String[] iller = {"Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya", "Ardahan", "Artvin", "Aydın", "Balıkesir", "Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir", "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis", "Kırıkkale", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Osmaniye", "Rize", "Sakarya", "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak"};
    private String[] Infolar = {" Kebap, Ciğer, Şırdan Dolması,","Dünyaya son kere bakacaksın deseler, bu bakışı Nemrutundan isterdim", " Güvenevler Mah. Mareşal Fevzi Çakmak Bulvarı 2096 Sok, D:No:2, 03030, Park Afyon AVM","Doktora gittim, ağrı nerde? Dedi. Doğu Anadolu bölgesinde dedim","Beyaz Saray","Elma","...... neden soğuktur? => 06 olduğu için.","Konyaaltı Plajı","Helle Aşı, Bişi, Mafiş Tatlısı"," Hopada bir akşam üstü öfkeli kızgın yağmur içinde ıslandım hem de iliklerime kadar ana caddeyi aştım boydan boya doğudan batıya.","Oldukça yüksektir paşa yaylası,Aşağıda kalır Aydın ovası.Aydın zeybeğidir efenin hası,Efeler diyarı güzel Aydınım.","Balıkların en korktuğu ilimiz neresidir?","Maden Kazası","Akşamları bir süper kahramana dönüşen şehrimiz hangisidir?","Tel helva, kesme çorba, tatlı çorba, kara pancar yemeği.","eski adıyla 'Ertuğrul'","100*10 göl","On minare",
            " Karadeniz Bölgesi’nin Batı Karadeniz bölümünde yer alır.","Şudur Burdur","İskender","Geçilmeyen Kale","Plaka 18","Leblebi","Horoz","Diyar diyar gezer bekir söyle bakim nedir fikir.","İleriye doğru git ..... git."," Marmara Bölgesi'nin Trakya kesiminde","ile doğudan Bingöl, kuzeyden Keban Baraj Gölü aracılığıyla Tunceli komşu olur.","Ercan","-40","Türkiyenin en eski şehiri?","Fıstık","Fındık","Evleri hane hane de parlayi .........","Sağ alt köşe","Antakya","Kardeş bizde çekirdeğe “çıtdama” denir.","Şehir, yöreye özgü el dokuması halılarıyla ve gül yetiştiriciliğiyle tanınmaktadır.","Megapolis","Gevrek","Dövme dondurması, tarhanası ve biberi","Siyah bük","Siyah Adam","Karsıki dağlar cenderme","Evliyalar şehri","Mantı","Komşuları Gaziantep ve Suriye'dir.","Bozuk Kale","40 arel","Yaşlı şehir","Dev eli","Yüz ölçümü en geniş","Küstah","Udemy kurucusu",
            " mesir çayı, Akhisar Köftesi, maden suyu, Manisa Kebabı, Alaşehir Kapaması","En kalabalık yirmi altıncı şehridir.'Merdin'","Tarsus","Onurcan","Burası ...'dur Yolu yokuştur","En yeni şehrimiz hangisidir?","..... Gazozu","Tabur","Aliye,Şabaniye...","Çay","Sürekli birşeyleri düşüren kişiye ne denir?","Atakum","Şan, şöhret","Züürt","Türkiye'nin Karadeniz Bölgesi'nin orta kesiminde bulunur.","Nuh'un gemisi tasvir edilmiştir.","-30","Bir sürü kedinin yaşadığı dağ hangisidir?","Çocukların en çok korktuğu şehir hangisidir?","Şampiyon","TürkEli","Çocuk","... gölü","Yüzölçümü itibarıyla Türkiye'nin en küçük ilidir","Eski ismi Bozok","Ereğli"};

    private Random rndIl, rndHarfAl;
    private int rndIlNumber, rndNumberHarf, Puan, Score;
    private String gelenIl, ilBoyutu , editTxtGelenTahmin, gelenInfo;
    private ArrayList<Character> ilHarfleri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sureli_oyun);
        txtIlBilgi = findViewById(R.id.txtIlBilgi);
        txtIlHarfSayisi = findViewById(R.id.txtIlHarfSayisi);
        txtPuan = findViewById(R.id.txtPuan);
        txtTime = findViewById(R.id.txtTime);
        txtInfo = findViewById(R.id.txtInfo);

        btnHarfAl = findViewById(R.id.btnHarfAl);
        btnPasGec = findViewById(R.id.btnPasGec);
        btnTahminEt = findViewById(R.id.btnTahminEt);

        editTxtTahminGiriniz = findViewById(R.id.editTxtTahminGiriniz);
        countDownTimer = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long l) {
                txtTime.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                btnHarfAl.setVisibility(View.INVISIBLE);
                btnPasGec.setVisibility(View.INVISIBLE);
                btnTahminEt.setVisibility(View.INVISIBLE);
                Toast.makeText(SureliOyunActivity.this, "Skorunuz: " + Score, Toast.LENGTH_LONG).show();
            }
        }.start();

        rndHarfAl = new Random();
        randomDegerleriBelirle();
    }


    public void HarfAl(View v) {

        if (ilHarfleri.size() > 0) {
            rndNumberHarf = rndHarfAl.nextInt(ilHarfleri.size());

            String[] txtHarfler = txtIlHarfSayisi.getText().toString().split(" ");
            char[] gelenIlHarfler = gelenIl.toCharArray();
            for (int i = 0; i < gelenIl.length(); i++) {
                if (txtHarfler[i].equals("_") && gelenIlHarfler[i] == ilHarfleri.get(rndNumberHarf)) {
                    txtHarfler[i] = String.valueOf(ilHarfleri.get(rndNumberHarf));
                    ilBoyutu = "";
                    Puan = Puan - 10;
                    System.out.println(Puan);
                    for (int j = 0; j < gelenIl.length(); j++) {
                        if (j == i) {
                            ilBoyutu += txtHarfler[j] + " ";
                        } else if (j < gelenIl.length() - 1)
                            ilBoyutu += txtHarfler[j] + " ";
                        else
                            ilBoyutu += txtHarfler[j];
                    }
                    break;
                }

            }
            txtIlHarfSayisi.setText(ilBoyutu);
            ilHarfleri.remove(rndNumberHarf);
        }
    }

    public void TahminEt(View v) {
        editTxtGelenTahmin = editTxtTahminGiriniz.getText().toString();
        editTxtTahminGiriniz.setText("");

        if (!TextUtils.isEmpty(editTxtGelenTahmin)) {
            if (editTxtGelenTahmin.equals(gelenIl)) {
                System.out.println("Doğru Tahminde bulundunuz");
                randomDegerleriBelirle();
                Score += Puan;
                txtPuan.setText("" + Score);
            }else
                System.out.println("Yanlış Tahminde Bulundunuz");

        } else
            System.out.println("Tahmin Değeri Boş Olamaz");
    }
    private void randomDegerleriBelirle(){
        ilBoyutu = "";
        rndIl = new Random();
        rndIlNumber = rndIl.nextInt(iller.length);
        gelenIl = iller[rndIlNumber];
        gelenInfo = Infolar[rndIlNumber];
        Puan = gelenIl.length() * 10;
        System.out.println(gelenIl);
        System.out.println(Puan);
        txtIlBilgi.setText(gelenIl.length() + " Harfli İlimiz");
        txtInfo.setText(gelenInfo);


        for (int i = 0; i < gelenIl.length(); i++) {
            if (i < gelenIl.length() - 1)
                ilBoyutu += "_ ";
            else
                ilBoyutu += "_";
            txtIlHarfSayisi.setText(ilBoyutu);
            ilHarfleri = new ArrayList<>();
            for (char c : gelenIl.toCharArray())
                ilHarfleri.add(c);
        }
    }
    public void pasGec(View view){
        randomDegerleriBelirle();
    }
}