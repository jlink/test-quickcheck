package simple;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Theories.class)
public class StringTheories {
    @Theory public void concatenationLength(
            @ForAll String s1,
            @ForAll String s2) {

        assertEquals(s1.length() + s2.length(), (s1 + s2).length());
    }
}