import java.util.Arrays;
import java.util.stream.Collectors;

public class ConvertToUpperCase {

    String convertToUppseStringUsingStreams(String input) throws IllegalArgumentException{

        if(input == null) {
            throw new IllegalArgumentException();
        }

        //note creating a stream from an input string
        return input
                .chars()
                .mapToObj(c -> Character.toString((char) c).toUpperCase())
                .collect(Collectors.joining());
    }

    String convertToUppseStringUsingStreams2(String input) throws IllegalArgumentException{

        if(input == null) {
            throw new IllegalArgumentException();
        }
        
        //note creating a stream from an input string
        return Arrays
                .stream(input.split(" "))
                .map(String::toUpperCase)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        ConvertToUpperCase obj = new ConvertToUpperCase();
        System.out.println(obj.convertToUppseStringUsingStreams("hello"));
        System.out.println(obj.convertToUppseStringUsingStreams2("helloworld"));
        System.out.println(obj.convertToUppseStringUsingStreams2("hELLo"));
    }
    
}
