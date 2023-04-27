package o6a_haveItemInCommon;

import java.util.HashMap;

public class Main {

    public static boolean itemInCommon (int[] array1, int [] array2){
        for (int int1 : array1){
            for (int int2 : array2){
                if(int1 == int2) return true;
            }
        }
        return false;
    }

    public static boolean itemInCommonCheckedByHashMap (int[] array1, int[] array2){
        HashMap<Integer, Boolean> myHashMap = new HashMap<>();

        for(int int1 : array1){
            myHashMap.put(int1, true);
        }
        for(int int2 : array2){
            if (myHashMap.get(int2) != null) return true;
        }   return false;
    }


    public static void main(String[] args) {


        boolean haveInCommon  = itemInCommon(new int[]{1, 3, 5}, new int[]{2, 4, 5});
        System.out.println(haveInCommon);

        boolean haveInCommonCheckedByHashMap  = itemInCommonCheckedByHashMap(new int[]{1, 3, 5}, new int[]{2, 4, 5});
        System.out.println(haveInCommonCheckedByHashMap);

    }
}
