package com.logact.bitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * medium 
 * bit manipulation
 */
public class GreyCode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<Integer>();
        int cb=1;
        res.add(0);
        for(int i=1;i<=n;i++){
            int size = res.size();
            for(int j=size-1;j>=0;j--){
                res.add(res.get(j)+cb);
            }
            cb=cb*2;
        }
        return res;

    }
}
