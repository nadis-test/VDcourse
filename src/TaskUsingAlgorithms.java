import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;

public class TaskUsingAlgorithms {

    public static void main(String args[]) {
        // "asd", "asds"
        Assertions.assertTrue(checkStrings("asd", "asds"));
        Assertions.assertFalse(checkStrings("asd", "sas"));
        Assertions.assertTrue(checkStrings("asd", "ass"));
        Assertions.assertFalse(checkStrings("asdf", "as"));
        Assertions.assertTrue(checkStrings("asds", "asd"));
        Assertions.assertFalse(checkStrings("asdf", "asfd"));
        Assertions.assertFalse(checkStrings("asd", "assf"));
        Assertions.assertFalse(checkStrings("as", "assf"));
        Assertions.assertFalse(checkStrings("asdf", "sadf"));
    }

    private static boolean checkStrings(String a, String b) {
        int acount = 0;
        int bcount = 0;
        int diffnum = 0;
        if (Math.abs(a.length() - b.length()) < 2) {
            while ( (acount < a.length()) && (bcount < b.length()) )  {
                if ((a.charAt(acount) != b.charAt(bcount)) )
                    if (a.length() == b.length()){
                        acount++;
                        bcount++;
                        diffnum++;
                    }
                  else  if (a.length() < b.length()) {
                        diffnum++;
                        bcount++;
                    }
                else {
                        diffnum++;
                        acount++;
                    }
                else{
                    acount++;
                    bcount++;
                }
            }
            return diffnum <= 1;
        }
        return false;
    }

}
