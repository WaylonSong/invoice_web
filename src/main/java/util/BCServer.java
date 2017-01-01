package util;

import java.util.Date;

/**
 * Created by song on 2016/12/23.
 */
public class BCServer {
    public static String SERVER_URL = "http://127.0.0.1:7050";
    public static String CCID = "50f2f52b9c398f63da1f450edcff0915959b57bb726ec04d46c5ff188f038dcc44183ca10425416af52b0a5cc332ef559434a4333f496ffe0654c5b1d233df39";
    public static String getTimeStamp(){
        return  ""+new Date().getTime()/1000;
    }

    public static void main(String args[]){
        System.out.println(getTimeStamp());
    }
}
