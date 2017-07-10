package ex.mcliam.wassap.model;

/**
 * Created by McLiam on 4/3/2017.
 */

import java.util.List;

public class Movie {

    private String status;
    private String message;
    private String kota;
    private String date;
    private List<MovieData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<MovieData> getData() {
        return data;
    }

    public void setData(List<MovieData> data) {
        this.data = data;
    }
}
