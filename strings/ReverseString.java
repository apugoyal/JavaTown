public class ReverseString {

    private String reverseUsingTwoPointers(String input) throws IllegalArgumentException {

        if(input == null){
            throw new IllegalArgumentException();
        }

        int i=0;
        int j=input.length() - 1;
        char[] inputArr = input.toCharArray();
        System.out.println(inputArr);

        while(i<j){
            char temp = inputArr[i];
            inputArr[i] = inputArr[j];
            inputArr[j] = temp; 

            i++;
            j--;
        }

        return new String(inputArr);
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println("aaaa");
        System.out.println(rs.reverseUsingTwoPointers("hello"));
        System.out.println(rs.reverseUsingTwoPointers("byefornow"));
    }
}