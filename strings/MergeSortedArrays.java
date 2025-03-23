import java.util.Arrays;

public class MergeSortedArrays {

    int[] merge(int[] arr1, int[] arr2) {

        if(arr1 == null || arr2 == null) {
            throw new IllegalArgumentException();
        }

        int i = 0;
        int j = 0;
        int[] result = new int[arr1.length + arr2.length];
        
        for(int k = 0; k<result.length; k++) {
            if( i<arr1.length && j<arr2.length) {
                if(arr1[i] < arr2[j]) {
                    result[k] = arr1[i];
                        i++;
                } else {
                    result[k] = arr2[j];
                    j++;
                }
                continue;
            }
            
            if(i >= arr1.length && j < arr2.length)  {
                result[k] = arr2[j];
                j++;
            }

            if(j >= arr2.length && i < arr1.length) {
                result[k] = arr1[i];
                i++;
            }
        }
        return result;
    } 

    public static void main(String[] args) {
        MergeSortedArrays obj = new MergeSortedArrays();
        
        int[] arr1 = {3, 4, 70, 80};
        int[] arr2 = {1, 2, 4, 5, 6, 8, 90, 100};

        int[] result = obj.merge(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}