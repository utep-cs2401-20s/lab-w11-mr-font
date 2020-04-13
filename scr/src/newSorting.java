public class newSorting {

    //newSort method
    public void newSort(int[] A, int B){
        //base case: A.length == B
        //
        //if the array is size B or less in length run the array through quickSort


        if (A.length <= B){

            quickSort(A, A[0], A[A.length-1]);
        }

        //recursive case, the A.length is > B
        //
        //create two new arrays, each one about half the size of our input array,
        // then populate them from the appropriate part of A and run the new arrays through newSort
        else{

            int[] leftHalfOfA = new int[A.length-1 / 2];
            int[] rightHalfOfA = new int[A.length / 2];

            for(int i = 0; i < A.length-1 / 2; i++){

                leftHalfOfA[i] = A[i];
            }

            for(int i = A.length / 2; i < A.length; i++){

                rightHalfOfA[i] = A[i];
            }

            newSort(leftHalfOfA, B);
            newSort(rightHalfOfA, B);
            mergeSortedHalves(leftHalfOfA, rightHalfOfA);
        }

    }

   public int[] quickSort(int[] A, int p, int h){

        int pivot = p;
        int low = p-1;
        int high = h;


        //base case: if there are one or zero elements to sort, we're done
        if(p >= h){
            return A;
        }

        int j = partition(A, A[0], A[A.length-1]);

        quickSort(A, p, j);
        quickSort(A,j+1, h);


   }

    public int partition(int[] A, int p, int h){

      int low = p+1;
      int high = h;
      int temp = 0;

      //int[] lowPartition = new int[1];

      int pivot = p;
      boolean done = false;

      while(!done){

          while(A[low] <= pivot){
              low++;
          }

          while(A[high] > pivot){
              high--;
          }

          if(low > high){

              temp = pivot;
              A[0] = A[high];
              A[high] = temp;

              done = true;
          }else{

              temp = A[low];
              A[low] = A[high];
              A[high] = temp;

              low++;
              high--;

          }

          //lowPartition[0] = high;
          return high;
      }



    }

    public void mergeSortedHalves(int[] leftHalf, int[] rightHalf){

        
    }

}
