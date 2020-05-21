package com.bbibm.memo.util;

import org.springframework.stereotype.Component;

@Component
public class SexUtil {

    public int stringToInt(String sex)
    {
        if(sex==null)
        {
            return 0;
        }
        if(sex.equals("男")||sex=="男")
        {
            return 1;
        }
        else {
            return 0;
        }
    }
}
