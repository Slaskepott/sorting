import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Sorter {
    int size;
    int[] array;
    String sett;
    String storrelse;
    String modus;

    //Kjøretidstesting
    int n = 0;
    int insertion_cmp = 0;
    int insertion_swaps = 0;
    int insertion_time = 0;
    int merge_cmp = 0;
    int merge_swaps = 0;
    int merge_time = 0;


    //Konstruktør for vanlig kjøring
    public Sorter(String sett, String storrelse,String modus,Scanner sc1,Scanner sc2){
        this.sett = sett;
        this.storrelse = storrelse;
        this.modus = modus;
        while(sc1.hasNextLine()){
            sc1.nextLine();
            size++;
        }
        array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = Integer.parseInt(sc2.nextLine());
        }
    }

    //Konstruktør for testing av kjøretid osv.
    public Sorter(String storrelse, Scanner sc){
        int n = Integer.parseInt(storrelse);
        String output = "n, alg1_cmp, alg1_swaps, alg1_time, alg2_cmp, alg2_swaps, alg2_time\n";

        //Opprett hele arrayet
        int[] arr = new int[n]; 
        int j=0;
        while(sc.hasNextLine()){
            arr[j] = Integer.parseInt(sc.nextLine());
            j++;
        }

        for(int i=1;i<n;i++){
            String linje = i+", ";    
            int[] skalTestes = slice(arr,0,i);
            insertionSort(skalTestes);
            linje += insertion_cmp+", "+insertion_swaps+", "+insertion_time+", ";
            reset();
            mergeSort(skalTestes);
            linje += merge_cmp+", "+merge_swaps+", "+merge_time+"\n";
            output += linje;
            reset();
        }

        try {
            FileWriter fw = new FileWriter(new File("resultater.out"));
            fw.write(output);
            fw.close();     
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void reset(){
        n = 0;
        insertion_cmp = 0;
        insertion_swaps = 0;
        insertion_time = 0;
        merge_cmp = 0;
        merge_swaps = 0;
        merge_time = 0;
    }

    public void insertionSort(int[] arr){
        long t = System.nanoTime();

        for(int i=1; i<arr.length; i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                insertion_cmp++;
                insertion_swaps++;
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        insertion_time = (int)(System.nanoTime()-t)/1000;
    }

    public int[] mergeSort(int[] a){
        long t = System.nanoTime();

        if(a.length<=1){
            return a;
        }
        int index = (int)Math.floor(a.length/2);
        int[] a1 = mergeSort(slice(a,0,index-1));
        int[] a2 = mergeSort(slice(a,index,a.length-1));

        merge_time = (int)(System.nanoTime()-t)/1000;

        return merge(a1,a2,a);
    }

    public int[] merge(int[]a1, int[] a2,int[] a){
        int i = 0;
        int j = 0;
        while(i<a1.length && j<a2.length){
            merge_cmp += 3;
            if(a1[i]<=a2[j]){
                merge_swaps++;
                a[i+j] = a1[i];
                i++;
            }
            else{
                merge_swaps++;
                a[i+j] = a2[j];
                j++;
            }
        }
        while(i<a1.length){
            merge_cmp++;
            merge_swaps++;
            a[i+j] = a1[i];
            i++;
        }
        while(j<a2.length){
            merge_cmp++;
            merge_swaps++;
            a[i+j] = a2[j];
            j++;
        }
        return a;
    }

    //Returnerer en ny array fra og med index start til og med index slutt
    public static int[] slice(int[] arr,int start, int slutt){
        if(start==slutt){
            int[] res = new int[1];
            res[0] = arr[start];
            return res;
        }
        int[] resultat = new int[slutt-start+1];

        for(int i=0; i<resultat.length; i++){
            resultat[i] = arr[start+i];
        }
        return resultat;
    }

    public void printArray(){
        for(int i : array){
            System.out.println(i);
        }
    }

    public void outArray(){
        try{
            FileWriter fw = new FileWriter(new File(storrelse+modus+".out"));
            for(int i:array){
                fw.write(Integer.toString(i)+"\n");
            }
            fw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
