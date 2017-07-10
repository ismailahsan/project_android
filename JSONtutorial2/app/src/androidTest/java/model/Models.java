
package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Models {

    private List<Actor> actors = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
