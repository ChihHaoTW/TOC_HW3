//javac -cp org.json.jar TocHW3.java
//java -cp .:org.json.jar TocHW3
import org.json.*;

public class TocHW3{

  public static void main(String args[]){
    String s = "{\"persons\":" + "[{\"name\":\"张三\",\"age\":20},{\"name\":\"李四\",\"age\":21}]" + "}";
    JSONObject jsonObj = new JSONObject(s);
    JSONArray ary = new JSONArray("[{\"name\":\"张三\",\"age\":20},{\"name\":\"李四\",\"age\":21}]");
    //System.out.println("姓名:"+result.getString("name")+" 年龄:"+result.getInt("age"));
    //解析object形式
    //s="{\"persons\":[\"张三\",\"李四\",\"王五\"]}";
    jsonObj = new JSONObject(s);
    //JSONArray jsonarr=jsonObj.getJSONArray("");
    int sum = 0;
    for(int i=0;i<ary.length();i++)
    {
      sum += ary.getJSONObject(i).getInt("age");
    }
    System.out.println((double)sum / ary.length());
}
}
