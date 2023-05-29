public class BankActivities {
    public static void main(String[] args) {
        Bank ali = new Bank(345,1400);
        Bank haydar = new Bank(356,400);
        Bank demir = new Bank(675,4350);
        ali.ParaCek(220);
        haydar.ParaYatir(455);
        demir.ParaCek(1420);
        Bank.BankaOzeti();
        ali.BilgileriGoster();
        haydar.BilgileriGoster();
        demir.BilgileriGoster();
        ali.Kiyasla(haydar);




    }
}
class Bank {
    private int hesapNo;
    private int hesaptakiPara;
    private static int tumBankaBakiyesi=0;
    private static int tumHesapSayisi=0;
    private static int operasyonSayisi=0;

    public Bank(int hesapNo, int hesaptakiPara) {
        this.hesapNo = hesapNo;
        this.hesaptakiPara = hesaptakiPara;
        tumBankaBakiyesi+=hesaptakiPara;
        tumHesapSayisi++;
    }

    public int getHesapNo() {
        return hesapNo;
    }

    public void setHesapNo(int hesapNo) {
        this.hesapNo = hesapNo;
    }

    public int getHesaptakiPara() {
        return hesaptakiPara;
    }

    public void setHesaptakiPara(int hesaptakiPara) {
        this.hesaptakiPara = hesaptakiPara;
    }
    public void ParaYatir(int paraMiktari) {
        this.hesaptakiPara+=paraMiktari;
        operasyonSayisi++;

    }
    public void ParaCek(int paraMiktari) {
        if(paraMiktari>this.hesaptakiPara) {
            System.out.println("Hesabinizda yeteri miktarda para yok");
        }else {
            this.hesaptakiPara-=paraMiktari;
            operasyonSayisi++;
            tumBankaBakiyesi-=paraMiktari;
        }
    }
    public static void BankaOzeti() {
        System.out.println("Bankadaki hesap sayisi = " +tumHesapSayisi);
        System.out.println("Bankadaki toplam para = " +tumBankaBakiyesi);
        System.out.println("Toplam işlem sayisi = " +operasyonSayisi);
    }
    public void BilgileriGoster() {
        System.out.println("Hesap no = " +getHesapNo());
        System.out.println("Bakiye = " +getHesaptakiPara());
    }
    public void Kiyasla(Bank kiyaslanacakKisi) {
        if(this.getHesaptakiPara()>kiyaslanacakKisi.getHesaptakiPara()) {
            System.out.println(getHesapNo()+" nolu hesabin bakiyesi " + kiyaslanacakKisi.getHesapNo()
                    +"nolu hesabin bakiyesinden fazladir");
        }
        else if(this.getHesaptakiPara()<kiyaslanacakKisi.getHesaptakiPara()) {
            System.out.println(getHesapNo()+" nolu hesabin bakiyesi " + kiyaslanacakKisi.getHesapNo()
                    +"nolu hesabin bakiyesinden azdir");
        }
        else {
            System.out.println(getHesapNo()+" nolu hesabin bakiyesi " + kiyaslanacakKisi.getHesapNo()
                    +"nolu hesabin bakiyesine esittir");

        }
    }
}
