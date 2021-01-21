package Models;

//encapsulation
public class UcusModel extends UcusAbstractClass {
    private Integer ucusID;
    private String kalkisYeri;
    private String varisYeri;
    private String kalkisZamani;
    private String biletTipi;

    public String getKalkisYeri() {
        return kalkisYeri;
    }

    public void setKalkisYeri(String kalkisYeri) {
        this.kalkisYeri = kalkisYeri;
    }

    public String getVarisYeri() {
        return varisYeri;
    }

    public void setVarisYeri(String varisYeri) {
        this.varisYeri = varisYeri;
    }

    public String getKalkisZamani() {
        return kalkisZamani;
    }

    public void setKalkisZamani(String kalkisZamani) {
        this.kalkisZamani = kalkisZamani;
    }

    public String getBiletTipi() {
        return biletTipi;
    }

    public void setBiletTipi(String biletTipi) {
        this.biletTipi = biletTipi;
    }

    public Integer getUcusID() {
        return ucusID;
    }

    public void setUcusID(Integer id) {
        this.ucusID = id;
    }

    //abstract ve final kullanımı
    @Override
    public String kalkisVeVarisYeri() {
        final String kalkisVarisYeri;
        kalkisVarisYeri = getKalkisYeri() + getVarisYeri();
        return kalkisVarisYeri;
    }
}
