public class InsertionSortExample {
    public static void main(String[] args) {
        int[] array = {5, 4, 1, 6, 9, 3, 0};
        for (int i = 1; i < array.length; i++) {
            int count = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[count] < array[j]) {
                    int temp = array[count];
                    array[count] = array[j];
                    array[j] = temp;
                    count--;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " / ");
        }
    }
}
