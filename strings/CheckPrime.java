import java.util.stream.IntStream;

public class CheckPrime {
    
    private boolean checkPrimeLoopNminus1(int input) {

        if(input<=1) return false;

        for(int i=2; i<input-1; i++) {
            if(input%i == 0) 
                return false;
        }

        return true;
    }
    

    private boolean checkPrimeStream(int input) {
        
        IntStream inputStream = IntStream.range(2, input);
        return inputStream.noneMatch(i -> input % i == 0);

    }

    public static void main(String[] args) {
        CheckPrime obj = new CheckPrime();
        System.out.println(obj.checkPrimeLoopNminus1(11));
        System.out.println(obj.checkPrimeStream(12));
    }    
}
