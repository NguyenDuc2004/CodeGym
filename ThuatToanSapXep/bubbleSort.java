public class bubbleSort {
    public static void BubbleSort(int[] list){
        for(int i = 0; i < list.length; i++){
            for(int j = i+1; j< list.length;j++){
                if(list[i] > list[j]){
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

}
