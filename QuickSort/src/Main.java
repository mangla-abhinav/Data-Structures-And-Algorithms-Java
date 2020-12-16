public class Main {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        quickSort(intArray, 0, intArray.length);

        for(int i=0;i< intArray.length;i++)
            System.out.print(intArray[i] +" ");
    }

    public static void quickSort(int[] input, int start, int end)
    {
        //Breaking Condition for recursion, breaks if length of array passed is 1.
        if(end - start < 2)
            return;

        //Function partition returns the position where the pivot element was inserted at it sorted position.
        int pivotIndex = partition(input, start, end);

        //Recursively calling quickSort with left sub array with position start to position pivotIndex, excluding pivotIndex as pivot element is at sorted position.
        //The end index is always 1 greater than the last valid index.
        quickSort(input, start, pivotIndex);

        //Recursively calling quickSort with right sub array with position pivotIndex+1(excluding pivotIndex as it is already at sorted position) to position end.
        quickSort(input, pivotIndex + 1, end);
    }

    //Function partition sorts the array and finds and returns the correct position of the pivot element.
    public static int partition(int[] input, int start, int end)
    {
        //We are using the first element as the pivot element.
        int pivot = input[start];

        int i = start;
        int j = end;

        //Loop to repeatedly traverse in the loop to find and replace elements.
        while(i < j)
        {
            //This is an empty loop to find the value of j
            while (i < j && input[--j] >= pivot);

            //If i did not cross j and the upper loop breaks because an element less than the pivot element is found, then replace element i with element j.
            if(i < j) {
                input[i] = input[j];
            }

            //This is an empty loop to find the value of j
            while(i < j && input[++i] <= pivot);

            //If i did not cross j and the upper loop breaks because an element greater than the pivot element is found, then replace element j with element i.
            if(i < j)
                input[j] = input[i];
        }

        //Loop at line 38 breaks breaks when i crosses j, at that time position j is the correct position of the pivot element.
        //So we assign position j to pivot and return index j.
        input[j] = pivot;
        return j;
    }
}
