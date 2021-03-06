import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StuInfoDeal {
    /**
     * 分三步走：
     *  第一步：获取CSV文件数据
     *  第二步：对数据按照要求排序
     *  第三步：将排好序的数据输出到控制台
     *  第四步：生成CSV文件并写入数据
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        Scanner s = new Scanner(System.in);
        File file = new File("D:" + File.separator + "File" + File.separator + "sutdentInfo.csv");                //文件路径
        File exportFile = new File("D:" + File.separator + "File" + File.separator + "ExportInfo.csv");                //文件路径
        if (!file.getParentFile().exists()) {                                                                               //父路径不存在
            System.out.println(file.getName() + " 不存在.");

        } else if (file.exists()) {                                                                        //文件存在
            System.out.println(file.getName() + " 存在.");
            System.out.println("请选择排序方式： 正序-请输入Z，倒序-请输入D：");
            String type = input.next();
            System.out.println("请选择要排序对象：学号-请输入0 年龄-请输入2  成绩-请输入3");
            int num = input.nextInt();
            //第一步 获取数据
            list = printInConsole(file);
            if(type.equals("Z")){
                //排序并输出到控制台
                List<String> tmpList = consoleShow(list,num);
                //生成文件并写入数据
                createCSV(exportFile,tmpList);
            }else if(type.equals("D")){
                //排序并输出到控制台
                List<String> tepList = consoleInfoInverse(list,num);
                //生成文件并写入数据
                createCSV(exportFile,tepList);
            }
        }
    }

    /**
     * 总共有四列，分别为：学号 姓名 年龄 成绩  用0  1 2 3 代替，可对学号 年龄 成绩进行排序
     * @param list
     * @param num
     * @return
     */

    //正序结果
    public static List<String> consoleShow(List<String> list,int num){   							//list代表从csv文件中获取到的数据，i代表要排序的对象
        List<String> copyList = new ArrayList<String>(); 												//用于返回排好序的list对象
        List<Integer> tmpList = new ArrayList<Integer>();
        if(list.size()>0){
            copyList.add(list.get(0));																	//将列名赋值给resList
            list.remove(0);
        }
        int [] arr = new int[list.size()];																//存放排序的数组
        int j=0;
        //获取须要排序的数组
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String res = it.next();																		//迭代获取一行数据
            String[] result = res.split(",");
            arr[j] = Integer.parseInt(result[num]);
            tmpList.add(Integer.parseInt(result[num]));													//按照list中排序索引的顺序，依次将数据放入tmpList当中
            j++;
        }
        bubbleSort(arr);																				//对数组进行排序
        //对list进行排序
        for(int k=0;k<arr.length;k++){
            int tmpNum = arr[k];
            System.out.println("tmpNum："+tmpNum);
            Iterator<Integer> itTmp = tmpList.iterator();
            while(itTmp.hasNext()){
                int temp = itTmp.next();
                if(tmpNum==temp){
                    int index = tmpList.indexOf(temp);												//获取到目标数值在tmpList中的下标
                    tmpList.set(index, -1);
                    copyList.add(list.get(index));
                    list.set(index, "");
                }
            }
        }
        Iterator<String> ite = copyList.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }
        return copyList;
    }

    //逆序数据
    public static List<String> consoleInfoInverse(List<String> list,int num){
        List<String> copyList = new ArrayList<String>(); 												//用于返回排好序的list对象
        List<Integer> tmpList = new ArrayList<Integer>();
        if(list.size()>0){
            copyList.add(list.get(0));																	//将列名赋值给resList
            list.remove(0);
        }
        int [] arr = new int[list.size()];																//存放排序的数组
        int j=0;
        //获取须要排序的数组
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String res = it.next();
            String[] result = res.split(",");
            arr[j]=Integer.parseInt(result[num]);
            tmpList.add(Integer.parseInt(result[num]));
            j++;
        }
        bubbleSortInverse(arr);
        //对list进行排序
        for(int k=0;k<arr.length;k++){
            int tmpNum = arr[k];
            System.out.println("tmpNum："+tmpNum);
            Iterator<Integer> itTmp = tmpList.iterator();
            while(itTmp.hasNext()){
                int temp = itTmp.next();
                if(tmpNum==temp){
                    int index = tmpList.indexOf(temp);												//获取到目标数值在tmpList中的下标
                    tmpList.set(index, -1);
                    copyList.add(list.get(index));
                    list.set(index, "");
                }
            }
        }
        Iterator<String> ite = copyList.iterator();
        while (ite.hasNext()){
            System.out.println(ite.next());
        }
        return copyList;
    }





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

    //写入CSV文件
    public static void createCSV(File file,List<String> list) throws Exception{
        String str  = String.valueOf(file);
        try {
            // 创建CSV写对象
            CsvWriter csvWriter = new CsvWriter(str,',', Charset.forName("GBK"));
            // 写表头
            Iterator<String> it = list.iterator();
            while(it.hasNext()){
                String[] singleInfo = it.next().split(",");
                csvWriter.writeRecord(singleInfo);
            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
