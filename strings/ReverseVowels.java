import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ReverseVowels {

    //Examples
    //hello -> holle
    //TaskQueue -> TeskQueua

    //init1 
    private final static Set<String> vowels1 = new HashSet<String>(Arrays.asList("a", "e", "i", "o", "u"));

    //init2
    //create a stream
    Stream<String> stream = Stream.of("a", "e", "i", "o", "u");
    
    Stream<String> stream2 = List.of("a", "e", "i", "o", "u").stream();
    Stream<String> stream3 = Arrays.asList("a", "e", "i", "o", "u").stream();
    
    // //reduce using collect
    private final Set<String> vowels2 = stream.collect(Collectors.toCollection(HashSet::new));

    // //init3
    private final Set<String> vowels3 = List
                                             .of("a", "e", "i", "o", "u")
                                             .stream()
                                             .collect(Collectors.toCollection(HashSet::new));

    // init4
    // RESULTS IN -> java.lang.IllegalStateException: stream has already been operated upon or closed in vowels2
    // private final Set<String> vowels4 = stream.collect(Collectors.toSet());
    // private final ArrayList<String> vowels5 = stream.collect(Collectors.toCollection(ArrayList::new));
    // private final List<String> list1 = stream.collect(Collectors.toList());

    //Use supplier
    Supplier<Stream<String>> stringSupplier = () -> Stream.of("a", "e", "i", "o", "u");
    private final Set<String> vowels4 = stringSupplier.get().collect(Collectors.toSet());
    private final ArrayList<String> vowels5 = stringSupplier.get().collect(Collectors.toCollection(ArrayList::new));
    private final List<String> list1 = stringSupplier.get().collect(Collectors.toList());
    
    private String ReverseVowelsUsingStack(String input) throws IllegalArgumentException {

        if(input == null){
            throw new IllegalArgumentException("custom message");
        }

        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<input.length(); i++) {
            String var = String.valueOf(input.charAt(i));
            if(vowels1.contains(var)){
                stack.push(var);
            }
        }

        for(int i=0; i<input.length(); i++) {
            String var = String.valueOf(input.charAt(i));
            if(vowels1.contains(var)){
                sb.append(stack.pop());
            } else {
                sb.append(var);
            }
        }
        return sb.toString();
    }

    private String ReverseVowelsUsingTwoPointers(String input) {
        //todo - null check
        
        int i = 0;
        int j = input.length() - 1;
        String temp = null;
        char[] charArr = input.toCharArray();

        while(i<j) {
            String left = String.valueOf(input.charAt(i));
            String right = String.valueOf(input.charAt(j));
            
            if(vowels1.contains(left) && vowels1.contains(right)) {
                temp = left;
                charArr[i] = right.charAt(0);
                charArr[j] = temp.charAt(0);
                //System.out.println(right +" "+ left);
            } else if(vowels1.contains(left)) {
                j--;
                continue;
            } else if(vowels1.contains(right)) {
                i++;
                continue;
            }
            i++;
            j--;
        }
        return new String(charArr);
    } 
    
    public static void main(String[] args) {

        ReverseVowels obj = new ReverseVowels();

        System.out.println(obj.vowels5);
        System.out.println(obj.ReverseVowelsUsingStack("hello"));
        System.out.println(obj.ReverseVowelsUsingTwoPointers("heloli11u2"));

    }
}