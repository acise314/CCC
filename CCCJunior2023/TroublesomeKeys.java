import java.io.*;
import java.util.*;

public class TroublesomeKeys {
    @SuppressWarnings("unchecked")
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int N = Integer.parseInt(br.readLine());
        String pressed = br.readLine();
        String printed = br.readLine();
        boolean quietKey = true;
        if (pressed.length() == printed.length()) {
            quietKey = false;
        }

        if (!quietKey) { // quiet key does not exist
            int index = 0;
            while (pressed.charAt(index) == printed.charAt(index)) {
                index++;
            }
            System.out.println(pressed.charAt(index) + " " + printed.charAt(index));
            System.out.println("-");
        } else { // quiet key exists
            Character silent = '.';
            for (int i = 0; i < pressed.length(); i++) {
                if (pressed.charAt(i) != printed.charAt(i)) {

                    //
                    silent = pressed.charAt(i);

                    String pressedNew = pressed.replaceAll(silent + "", "");

                    int index = 0;
                    while (printed.charAt(index) == pressedNew.charAt(index)) {
                        index++;
                    }
                    if (pressedNew.replace(pressedNew.charAt(index), printed.charAt(index)).equals(printed)) {
                        // then index isnot the silly
                        System.out.println(pressedNew.charAt(index) + " " + printed.charAt(index));
                        System.out.println(silent);
                        break;
                    } //
                    else {
                        Character silly = pressed.charAt(i);
                        Character sillyResult = printed.charAt(i);
                        String printedNNew = printed.replace(sillyResult, silly);
                        int indexx = 0;
                        while (indexx < printedNNew.length()) {
                            if (pressed.charAt(indexx) != printedNNew.charAt(indexx)) {
                                break;
                            }
                            indexx++;
                        }
                        if (pressed.charAt(indexx) == printedNNew.charAt(indexx - 1)) {
                            indexx++;
                        }

                        System.out.println(silent + " " + sillyResult);
                        System.out.println(pressed.charAt(indexx));
                        break;
                    }
                }
            }
        }
    }
}
