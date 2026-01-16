public class Main {
    public static void inputList(int[] list){
        for(int i = 0; i < list.length;i++){
            System.out.print(" " + list[i]);
        }
    }

    public static void main(String[] args) {
         int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
         System.out.println("Ttoan noi bot");
         bubbleSort.BubbleSort(list);
         System.out.println("Sau khi noi bot: ");
         inputList(list);
    }
}
