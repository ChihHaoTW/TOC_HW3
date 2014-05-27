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
        JSONArray ary = new JSONArray(read("5365dee31bc6e9d9463a0057"));

        long sum = 0;
        int length = 0;
        for(int i=0;i<ary.length();i++)
        {
            try
            {
                if (!ary.getJSONObject(i).getString("鄉鎮市區").equals("大安區")) 
                    continue;
                //System.out.println(ary.getJSONObject(i).getString("鄉鎮市區"));
            }
            catch(org.json.JSONException e1)
            {
                System.out.println("鄉鎮市區 error");
                continue;
            }

            try
            {
                if (ary.getJSONObject(i).getString("土地區段位置或建物區門牌").indexOf("復興南路") == -1) 
                    continue;
                //System.out.println(ary.getJSONObject(i).getString("鄉鎮市區"));
            }
            catch(org.json.JSONException e2)
            {
                System.out.println("土地區段位置或建物區門牌 error");
                continue;
            }

            try
            {
                if (ary.getJSONObject(i).getInt("交易年月") < (103*100)) 
                    continue;
                //System.out.println(ary.getJSONObject(i).getString("鄉鎮市區"));
            }
            catch(org.json.JSONException e3)
            {
                System.out.println("交易年月 error");
                continue;
            }


            try
            {
                sum += ary.getJSONObject(i).getInt("總價元");
            }
            catch(org.json.JSONException e4)
            {
                System.out.println("總價元 error");
                length--;
            }

            length++;
            //System.out.println(i);
        }
        System.out.println(sum / length); // when length = 0 ?
    }
}
