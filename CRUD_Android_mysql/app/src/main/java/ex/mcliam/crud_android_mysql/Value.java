package ex.mcliam.crud_android_mysql;

/**
 * Created by McLiam on 6/1/2017.
 */

import java.util.List;

public class Value {

    String value;
    String message;
    List<Result> result;

    public String getValue(){
        return value;
    }

    public String getMessage(){
        return message;
    }

    public List<Result> getResult() {
        return result;
    }

}
