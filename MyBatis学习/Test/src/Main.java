import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    /*在保证初始代码结构不变的情况下，可以通过下面“char_count”一个函数实现题目的要求，也可以通过多个函数实现*/

    /*=============这里往下是你主要编写代码的地方，此区域外的代码都不能删除==================*/

    /*入口函数，不能删除，因为在下方“main”函数中有调用*/
    static String char_count(String str) {
        if(str==null){
            return null;
        }
        int length = str.length();
        if(length==1){
            return "1"+str;
        }
        StringBuilder builder = new StringBuilder();
        int index = 0, count = 1;
        String res = null;
        for (int i = 1; i < length; i++) {

            if(str.charAt(i) == str.charAt(i-1)){
                count++;
                //  判断是否到达最后一个字符
                if(i+1 == length){
                    builder.append(count);
                    builder.append(str.charAt(i-1));
                }
            }else{
                builder.append(count);
                builder.append(str.charAt(i-1));
                count = 1;
                if(i==length-1){
                    builder.append(count);
                    builder.append(str.charAt(i));
                }
            }
        }

        res = builder.toString();
        return res;
    }

    /*其他函数可以从这里写起*/

    /*=============这里往上是你主要编写代码的地方，此区域外的代码都不能删除==================*/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }

        /*以下代码根据需要，可以适当修改*/
        res = char_count(_str);    //
        System.out.println(res);
    }
}


//
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//public class Main {
//
//
//    /*在保证初始代码结构不变的情况下，可以通过下面“arraySort”一个函数实现题目的要求，也可以通过多个函数实现*/
//
//    /*=============这里往下是你主要编写代码的地方，此区域外的代码都不能删除==================*/
//
//    /*入口函数，不能删除，因为在下方有调用*/
//    static int[] arraySort(int[] arr) {
//        if(arr==null){
//            return arr;
//        }
//        sort(arr, 0, arr.length-1);
//        return arr;
//    }
//
//    static void sort(int arr[], int start, int end){
//        if(start>=end){
//            return;
//        }
//        int base = arr[start];
//        int l = start, r = end;
//        while(l<r){
//            /*
//            * [5, 1, 2]
//            * [2, 1, 5]
//            * */
//            while(arr[r] >= base && l< r){
//                r--;
//            }
//            while(arr[l] <= base && l< r){
//                l++;
//            }
//            if(l<r){
//                swap(arr, l, r);
//            }
//        }
//        swap(arr, start, r);
//        sort(arr, start, r-1);
//        sort(arr, r+1, end);
//    }
//
//    static void swap(int[] arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//    /*其他函数可以从这里写起*/
//
//    /*=============这里往上是你主要编写代码的地方，此区域外的代码都不能删除==================*/
//
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int[] res;
//
//        int _arr_size = 0;
//        _arr_size = Integer.parseInt(in.nextLine().trim());
//        int[] _arr = new int[_arr_size];
//        int _arr_item;
//        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
//            _arr_item = Integer.parseInt(in.nextLine().trim());
//            _arr[_arr_i] = _arr_item;
//        }
//
//        res = arraySort(_arr);
//        for(int res_i=0; res_i < res.length; res_i++) {
//            System.out.println(String.valueOf(res[res_i]));
//        }
//
//    }
//}
