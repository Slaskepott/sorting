import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sort {
    /*
     *          ***README***
     * Programmet tar tre argumenter i CLI.
     * ENTEN:
     * [0] Eksakt streng, enten "random" eller "nearly_sorted"
     * [1] Eksakt streng, enten "10","100","1000","10000","100000" eller "1000000"
     * [2] Eksakt streng, enten "insertion" eller "merge"
     * ELLER:
     * [0] Eksakt streng, "compare"
     * [1] Eksakt streng, enten "random" eller "nearly_sorted"
     * [2] Eksakt streng, enten "10","100","1000","10000","100000" eller "1000000"
     */
    
    public static void main(String[] args){
        if(args[0].equals("compare")){
            compare(args);
            return;
        }
        try{
            String sett = args[0];
            String size = args[1];
            String modus = args[2];
            String filnavn = "./inputs/"+sett+"_"+size;

            Sorter s = new Sorter(sett,size,modus, new Scanner(new File(filnavn)),new Scanner(new File(filnavn)));
            if(modus.equals("insertion")){
                s.insertionSort(s.array);
            }else if(modus.equals("merge")){
                s.mergeSort(s.array);
            }
            s.outArray();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    public static void compare(String[] args){
        String sett = args[1];
        String size = args[2];
        String filnavn = "./inputs/"+sett+"_"+size;

        try{
            Sorter s = new Sorter(size,new Scanner(new File(filnavn)));
        }catch(FileNotFoundException e){
            System.out.println(filnavn);
            System.out.println(e);
        }

    }
}
