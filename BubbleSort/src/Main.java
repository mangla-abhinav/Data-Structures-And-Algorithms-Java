public class Main {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for(int unsortedPartitionIndex = intArray.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--)
        {
            for(int i=0;i < unsortedPartitionIndex; i++)
            {
                if(intArray[i] > intArray[i + 1])
                    swap(intArray, i, i + 1);
            }
        }

        for(int i=0; i<intArray.length;i++)
        {
            System.out.print(intArray[i] + " ");
        }
    }

    public static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
