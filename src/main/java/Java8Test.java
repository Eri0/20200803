import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class Java8Test {
    @Test
    public void  test(){
        Consumer<String> t = x -> System.out.println(x);
        t.accept("sss");
    }

    @Test
    public  void  ttest(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        System.out.println(com.compare(1,2));

    }
}
