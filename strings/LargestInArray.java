public class LargestInArray {

    private int findLargest(int[] input) throws IllegalArgumentException {

        if(input == null) {
            throw new IllegalArgumentException();
        }

        int temp = input[0];

        for(int i=1; i<input.length; i++) {
            if(input[i]>temp) {
                temp = input[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        LargestInArray obj = new LargestInArray();

        //note - how array is initialized
        int[] input =  {10, 20, 5, 100, 50};
        System.out.println(obj.findLargest(input));
    }
    
}
