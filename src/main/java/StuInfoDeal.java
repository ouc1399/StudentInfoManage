import com.csvreader.CsvReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StuInfoDeal {


    //获取CSV文件数据
    public static List<String> printInConsole(File file) throws Exception{
        List<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        CsvReader creader = new CsvReader(reader,',');
        int num =0;
        while(creader.readRecord()){
            String str = creader.getRawRecord();													//读取一行数据
            list.add(str);
        }
        creader.close();
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        return list;
    }








    //正序函数
    public static void bubbleSort(int arr[]){
        int length = arr.length;
        int i,j,temp;
        for(i=1;i<length;i++){
            for(j=0;j<length-i;j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int k=0;k<arr.length;k++)
            System.out.println(arr[k]);
    }

    //逆序函数
    public static void bubbleSortInverse(int arr[]){
        int length = arr.length;
        int i,j,temp;
        for(i=1;i<length;i++){
            for(j=0;j<length-i;j++){
                if(arr[j] <= arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int k=0;k<arr.length;k++)
            System.out.println(arr[k]);
    }




}
