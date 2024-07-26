import java.io.*;
import java.util.*;

public class DusaAndTheYobis {
@SuppressWarnings("unchecked")
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());
        boolean tf =true;
        while (tf){
            int x = Integer.parseInt(br.readLine());
            if (D > x){
                D = D + x;
            }
            else{
                tf = false;
                break;
            }
        }
        System.out.println(D);
    }
}
