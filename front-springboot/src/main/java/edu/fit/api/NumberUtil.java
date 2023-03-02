package edu.fit.api;

import java.util.Random;

public class NumberUtil {
    public static String eiNumberUtil(){
        long l = System.currentTimeMillis();
        Random random = new Random();
        String str = String.valueOf(l);
        int i = random.nextInt(1000);
        if(i<10){
            str+="00"+i;
        }else if (i>=10 && i<100){
            str+="0"+i;
        }else {
            str+=i;
        }
        return str;
    }

}
