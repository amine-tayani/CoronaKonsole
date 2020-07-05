package api;

import java.io.Serializable;

public class Covid implements Serializable {
    public String country;
    public String code;
    public int confirmed;
    public int recovered;
    public int critical;
    public int deaths;
    public float latitude;
    public float longitude;
    public String lastChange;
    public String lastUpdate;

    public Covid() { }

    public Covid(String country, String code, int confirmed,
                 int recovered, int critical, int deaths,
                 float latitude, float longitude, String lastChange, String lastUpdate) {
        this.country = country;
        this.code = code;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.critical = critical;
        this.deaths = deaths;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lastChange = lastChange;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return
                "\n\n"+country+" report | day : "+lastUpdate +"\n" +
                "      Confirmed Cases : " + confirmed +"\n"+
                "      Recovered Cases : " + recovered +"\n"+
                "      Critical Cases : " + critical +"  \n"+
                "      Deaths : " + deaths +"\n";
    }
}