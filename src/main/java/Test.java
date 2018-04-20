import org.junit.Test;
public class test {

    int[] arr={12,3,2,8,4};


    @Test
    public void Sort() throws Exception {
        StuInfoDeal.bubbleSort(arr);
    }

    @Test
    public void SortInverse() throws Exception {
        StuInfoDeal.bubbleSortInverse(arr);
    }
}
