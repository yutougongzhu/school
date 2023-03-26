package p1;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class login {
    String userid;
    String userpasd;
    Boolean Remember = false;
    String nleurl = "http://api.nlecloud.com/Users/Login";
    private String qwe;
    public login(String userid, String userpasd, Boolean remember) {
        this.userid = userid;
        this.userpasd = userpasd;
        Remember = remember;
    }

    public login(String userid, String userpasd) {
        this.userid = userid;
        this.userpasd = userpasd;
    }
    public void one(){
        try {
            URL url = new URL(nleurl);
            HttpURLConnection httpURLConnection  = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            String message = "Account="+userid+"&Password="+userpasd+"&IsRememberMe="+true+"";
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader  = new BufferedReader(inputStreamReader);
            qwe = "";
            while (bufferedReader.read()!=-1){
                qwe += bufferedReader.readLine();
            }
//            System.out.println(qwe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String gettoken(){
        String[] mes = qwe.split("\"");
        String token = mes[33];
        return token;
    }
}
