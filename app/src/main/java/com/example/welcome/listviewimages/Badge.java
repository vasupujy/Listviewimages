package com.example.welcome.listviewimages;

import java.io.Serializable;

/**
 * Created by welcome on 25-02-2016.
 */
public class Badge implements Serializable{
    private String bronze;
    private String silver;
    private String gold;

    public String getBronze() {
        return bronze;
    }

    public void setBronze(String bronze) {
        this.bronze = bronze;
    }

    public String getSilver() {
        return silver;
    }

    public void setSilver(String silver) {
        this.silver = silver;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }
}
