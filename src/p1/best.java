package p1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class best {
    public static void main(String[] args) {
        login login = new login("18912626497","mzy314159");
        login.one();
        getdata getdata = new getdata(640467,"Z_WEN",login.gettoken());
        String data = getdata.getthedata();
        Pattern pattern = Pattern.compile("(?<=\"Value\":)(.*?)(?=,)");
        Matcher ma = pattern.matcher(data);
        System.out.println(data);
        if (ma.find()){
            System.out.println(ma.group());
        }
        System.out.println();
    }
}
