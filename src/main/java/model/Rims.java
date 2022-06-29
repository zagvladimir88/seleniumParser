package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rims")
public class Rims {

    @Id
    @Column(name = "ArtNm")
    private String  ArtNm;
    @Column(name = "GoodsGroup")
    private String  GoodsGroup;
    @Column(name = "rimsize")
    private String  rimsize;
    @Column(name = "numofhols")
    private String  numofhols;
    @Column(name = "hubhol")
    private String  hubhol;
    @Column(name = "pcd")
    private String  pcd;
    @Column(name = "vilet")
    private String  vilet;
    @Column(name = "color")
    private String  color;

    public Rims() {
    }

    public Rims(String artNm, String goodsGroup, String rimsize, String numofhols, String hubhol, String pcd, String vilet, String color) {
        ArtNm = artNm;
        GoodsGroup = goodsGroup;
        this.rimsize = rimsize;
        this.numofhols = numofhols;
        this.hubhol = hubhol;
        this.pcd = pcd;
        this.vilet = vilet;
        this.color = color;
    }

    public String getArtNm() {
        return ArtNm;
    }

    public void setArtNm(String artNm) {
        ArtNm = artNm;
    }

    public String getGoodsGroup() {
        return GoodsGroup;
    }

    public void setGoodsGroup(String goodsGroup) {
        GoodsGroup = goodsGroup;
    }

    public String getRimsize() {
        return rimsize;
    }

    public void setRimsize(String rimsize) {
        this.rimsize = rimsize;
    }

    public String getNumofhols() {
        return numofhols;
    }

    public void setNumofhols(String numofhols) {
        this.numofhols = numofhols;
    }

    public String getHubhol() {
        return hubhol;
    }

    public void setHubhol(String hubhol) {
        this.hubhol = hubhol;
    }

    public String getPcd() {
        return pcd;
    }

    public void setPcd(String pcd) {
        this.pcd = pcd;
    }

    public String getVilet() {
        return vilet;
    }

    public void setVilet(String vilet) {
        this.vilet = vilet;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Rims{" +
                "ArtNm='" + ArtNm + '\'' +
                ", GoodsGroup='" + GoodsGroup + '\'' +
                ", rimsize='" + rimsize + '\'' +
                ", numofhols='" + numofhols + '\'' +
                ", hubhol='" + hubhol + '\'' +
                ", pcd='" + pcd + '\'' +
                ", vilet='" + vilet + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
