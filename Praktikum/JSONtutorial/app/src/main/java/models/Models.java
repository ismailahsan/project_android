
package models;

import java.util.HashMap;
import java.util.Map;

public class Models {

    private Admin admin;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
