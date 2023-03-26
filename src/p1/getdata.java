package p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class getdata {
    int deviceId;
    String apiTag;
    String token;

    public getdata(int deviceId, String apiTag , String token) {
        this.deviceId = deviceId;
        this.apiTag = apiTag;
        this.token = token;
    }
    public String getthedata(){
        String rl = "http://api.nlecloud.com/devices/"+deviceId+"/Sensors/"+apiTag+"";
        try {
            URL url = new URL(rl);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.addRequestProperty("AccessToken",token);
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String value = "";
                while (bufferedReader.read()!=-1){
                    value+=bufferedReader.readLine();
                }
//                System.out.println(value);
                return value;

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
