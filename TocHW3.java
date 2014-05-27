//javac -cp org.json.jar TocHW3.java
//java -cp .:org.json.jar TocHW3
import org.json.*;
import java.io.*;

public class TocHW3 
{
    public static String read(String filename) throws IOException {  
        // 使用BufferedReader进行缓冲，来提高文件的读取数据  
        BufferedReader in = new BufferedReader(new FileReader(filename));  
        String s;  
        StringBuilder sb = new StringBuilder();  
        while ((s = in.readLine()) != null)  
            sb.append(s + "\n");  
        in.close();  
        return sb.toString();  
    }  

    public static void main(String args[]) throws IOException
    {
        //FileReader jsonfile = new FileReader("5365dee31bc6e9d9463a0057");
        String s = "{\"persons\":" + "[{\"name\":\"张三\",\"age\":20},{\"name\":\"李四\",\"age\":21}]" + "}";
        JSONObject jsonObj = new JSONObject(s);
        //JSONArray ary = new JSONArray("[{\"name\":\"张三\",\"age\":20},{\"name\":\"李四\",\"age\":21}]");
        JSONArray ary = new JSONArray(read("5365dee31bc6e9d9463a0057"));
        //System.out.println("姓名:"+result.getString("name")+" 年龄:"+result.getInt("age"));
        //解析object形式
        //s="{\"persons\":[\"张三\",\"李四\",\"王五\"]}";
        jsonObj = new JSONObject(s);
        //JSONArray jsonarr=jsonObj.getJSONArray("");
        long sum = 0;
        int length = 0;
        for(int i=0;i<ary.length();i++)
        {
            try
            {
                if (ary.getJSONObject(i).getString("鄉鎮市區") != "文山區") 
                    continue;
            }
            catch(org.json.JSONException e1)
            {
                continue;
            }

            try
            {
                sum += ary.getJSONObject(i).getInt("總價元");
            }
            catch(org.json.JSONException e2)
            {
                length--;
            }

            length++;
            //System.out.println(ary.getJSONObject(i));
        }
        System.out.println(sum / length); // when length = 0 ?
    }
}
