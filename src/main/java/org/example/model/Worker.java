package org.example.model;

public class Worker {
    private Integer id;
    private String ad;
    private String soyad;
    private String vəzifə;
    private Integer maaş;
    private Integer yaş;
    private String şöbə;

    public Worker() {

    }

    public Worker(Integer id, String ad, String soyad, String vəzifə, Integer maaş, Integer yaş, String şöbə) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.vəzifə = vəzifə;
        this.maaş = maaş;
        this.yaş = yaş;
        this.şöbə = şöbə;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getVəzifə() {
        return vəzifə;
    }

    public void setVəzifə(String vəzifə) {
        this.vəzifə = vəzifə;
    }

    public Integer getMaaş() {
        return maaş;
    }

    public void setMaaş(Integer maaş) {
        this.maaş = maaş;
    }

    public Integer getYaş() {
        return yaş;
    }

    public void setYaş(Integer yaş) {
        this.yaş = yaş;
    }

    public String getŞöbə() {
        return şöbə;
    }

    public void setŞöbə(String şöbə) {
        this.şöbə = şöbə;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", vəzifə='" + vəzifə + '\'' +
                ", maaş=" + maaş +
                ", yaş=" + yaş +
                ", şöbə='" + şöbə + '\'' +
                '}';
    }
}