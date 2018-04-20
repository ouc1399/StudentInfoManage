public class StuInfoDeal {


    //正序
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

}
