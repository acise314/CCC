import java.io.*;
import java.util.*;

public class BronzeCount {
    @SuppressWarnings("unchecked")
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        Collections.reverse(arr);
        int first = arr.get(0);
        int second = -1;
        for (int j = 0; j < N; j++) {
            if (arr.get(j) != first) {
                second = arr.get(j);
                break;
            }
        }
        int third = -1;
        for (int k = 0; k < N; k++) {
            if (arr.get(k) != first && arr.get(k) != second) {
                third = arr.get(k);
                break;
            }
        }
        int count= 0;
        for (int u = 0; u < N; u++){
            if (arr.get(u) == third){
                count++;
            }
        }
        System.out.println(third + " " + count);
    }
}
