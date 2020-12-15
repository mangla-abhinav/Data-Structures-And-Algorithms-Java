public class Main {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);

        for(int i=0;i< intArray.length;i++)
            System.out.print(intArray[i] + " ");
    }

    public static void mergeSort(int[] input, int start, int end)
    {
        if(end - start < 2)
            return;

        int mid = (start + end)/2;

        mergeSort(input, start, mid); //Splitting left partition
        mergeSort(input, mid, end); //Splitting right partition

        merge(input, start, mid, end); //Merging and sorting splitted partitions
    }

    public static void merge(int[] input, int start, int mid, int end)
    {
        if(input[mid-1] <= input[mid])
            return;
        //Optimization -->> In merging, if rightmost element in left sorted array is less than or equal to leftmost element of right sorted array,
        // the whole array is already sorted as both the arrays were already in sorted order.


        int i = start; //Setting i equal to leftmost element of left array
        int j = mid; //Setting j to leftmost element of right array
        int tempIndex = 0;  //Variable to track number of elements shifted to temporary array

        int[] temp = new int[end - start]; //Temporary array with length of sum of left and right array

        while(i < mid && j < end) //loop to traverse inside arrays to compare ans shift elements to temp array
        {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start+tempIndex, mid-i);
        //Copying left over elements in case we copy all the elements in one array and elements in other array are left.
        //Optimization -->> We do not need to copy left over elements from right array as they will already be in sorted order at their correct position
        //So we only copy left over elements from left array
        //start + tempIndex is the destination position to copy elements, this will take us to the position till where elements were copied.
        //mid-i is the number of elements to copy which will give the number of remaining elements in the left array

        System.arraycopy(temp, 0, input, start, tempIndex); //Copying temporary array back to original array
    }
}