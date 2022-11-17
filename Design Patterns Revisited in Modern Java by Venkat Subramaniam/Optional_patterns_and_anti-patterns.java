import java.util.List;
import java.util.Optional;

// Design Patterns Revisited in Modern Java by Venkat Subramaniam : https://www.youtube.com/watch?v=yTuwi--LFsM&t=349s

public class ClientMain {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            var result = getNameStringwithOp(); // [4] no risk of null
            System.out.println(result.orElse("Not found")); // [5] Reasonable approach way to extract  the data out. Avoid .get()
        }
    }

    public static void setName(){
        // [10]  Use Default  Good Example
    }
    public static void setName(String name){
        // [10.2] Set Name  Good Example
    }

    // [9] Very bad !! Avoid !!
    public static void setName(Optional<String> name){
    }

    public static void setNameBad(String name){
        if(name == null) { // [6] smell ( bad ) 
            // use default value of Joe [7] smell ( bad )
        }
        // Use given name [8] smell ( bad )
    }

    public static Optional<String> getNameStringwithOp() {
        if (Math.random() > 0.5) {
            return Optional.of("Joe");
        }
        return Optional.empty(); // [3] Best Idea
    }

    public static String getNameString() {
        return null; // [2] Bad Idea
    }

    public static List<String> getNameList() {
        return List.of(); // [1] If there are no names , its better to return an empty list
    }
}