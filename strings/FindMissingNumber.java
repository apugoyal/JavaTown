import java.util.stream.IntStream;

public class FindMissingNumber {
    
    //array will be provided

    int findMissingNumberLoop(int[] arr, int sum){

        for(int i=0; i<arr.length; i++) {
            sum = sum - arr[i];
        }
        return sum;
    }

    int findMissingNumberStream(int[] arr, int sum){
        int length = arr.length;
        int arrSum = IntStream.rangeClosed(arr[0], arr[length-1]).sum();
        return sum - arrSum;
    }

    public static void main(String[] args) {
        FindMissingNumber obj = new FindMissingNumber();
        int[] arr = {1,2,3,4,5};
        System.out.println(obj.findMissingNumberLoop(arr, 21));
        System.out.println(obj.findMissingNumberStream(arr, 21));
    }
}
