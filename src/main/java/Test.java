import org.junit.Test;

import java.io.File;

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
    public void showConsole() throws Exception {
        StuInfoDeal.printInConsole(file);
    }
}
