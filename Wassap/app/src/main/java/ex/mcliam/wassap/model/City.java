package ex.mcliam.wassap.model;

/**
 * Created by McLiam on 4/3/2017.
 */

import java.util.List;

public class City {
    private String status;
    private String message;
    private List<CityData> data;

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

    public List<CityData> getData() {
        return data;
    }

    public void setData(List<CityData> data) {
        this.data = data;
    }
}

