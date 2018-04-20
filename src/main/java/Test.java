import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class test {

    int[] arr={12,3,2,8,4};
    File file = new File("D:"+File.separator+"File"+File.separator+"sutdentInfo.csv");












    @Test
    public void Sort() throws Exception {
        StuInfoDeal.bubbleSort(arr);
    }

    @Test
    public void SortInverse() throws Exception {
        StuInfoDeal.bubbleSortInverse(arr);
    }

    @Test
    public void getCSVData() throws Exception {
        StuInfoDeal.printInConsole(file);
    }

    @Test
    public void showInConsole() throws Exception {
        List<String> conList = new ArrayList<String>();
        conList.add("学号,姓名,年龄,成绩");
        conList.add("4,jack1,16,85");
        conList.add("2,jack2,14,75");
        conList.add("7,jack3,15,77");
        conList.add("5,jack5,18,88");
        conList.add("1,jack4,17,76");
        conList.add("3,jack7,17,67");
        conList.add("9,jack9,13,67");
        conList.add("6,jack6,21,95");
        conList.add("8,jack8,16,82");
        conList.add("10,jack10,12,91");
        StuInfoDeal.consoleShow(conList,0);
    }

    @Test
    public void showInConsoleInverse() throws Exception {
        List<String> conList = new ArrayList<String>();
        conList.add("学号,姓名,年龄,成绩");
        conList.add("4,jack1,16,85");
        conList.add("2,jack2,14,75");
        conList.add("7,jack3,15,77");
        conList.add("5,jack5,18,88");
        conList.add("1,jack4,17,76");
        conList.add("3,jack7,17,67");
        conList.add("9,jack9,13,67");
        conList.add("6,jack6,21,95");
        conList.add("8,jack8,16,82");
        conList.add("10,jack10,12,91");
        StuInfoDeal.consoleInfoInverse(conList,0);
    }

    @Test
    public void createFile() throws Exception {
        List<String> conList = new ArrayList<String>();
        conList = StuInfoDeal.printInConsole(file);
        file = new File("D:"+File.separator+"File"+File.separator+"exportInfo.csv");
        StuInfoDeal.createCSV(file,conList);
    }



}
