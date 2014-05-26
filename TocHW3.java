//javac -cp org.json.jar TocHW3.java
//java -cp .:org.json.jar TocHW3
import org.json.*;

public class TocHW3{

  public static void main(String args[]){
    String s = "{\"person\":{\"name\":\"张三\",\"age\":20}}";
    JSONObject jsonObj = new JSONObject(s);
    JSONObject  result = jsonObj.getJSONObject("person");
    System.out.println("姓名:"+result.getString("name")+" 年龄:"+result.getInt("age"));
    //解析object形式
    s="{\"persons\":[\"张三\",\"李四\",\"王五\"]}";
    jsonObj = new JSONObject(s);
    JSONArray jsonarr=jsonObj.getJSONArray("persons");
    for(int i=0;i<jsonarr.length();i++){
        System.out.println(jsonarr.getString(i));
        }
}
}
