package util;

import java.util.UUID;

/**
 * Created by song on 2016/12/21.
 */
public class IdGenerator {
    public static String getClientUUID(){
        return ("C_"+ UUID.randomUUID()).replace("-","");
    }
    public static void main(String args[]){
        System.out.println(IdGenerator.getClientUUID());
    }
}
