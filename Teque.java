import java.util.ArrayList;

class Teque{
    private int[] tall;
    private ArrayList<Integer> output = new ArrayList<>();
    int size = 0;

    public Teque(int s){
        tall = new int[s];
    }

    public void push_back(int x){
        tall[size] = x;
        size++;
    }

    public void push_front(int x){
        int i = size;
        while(i>=0){
            tall[i+1] = tall[i];
            i--;
        }
        tall[0] = x;
        size++;
    }

    public void push_middle(int x){
        if(size==0){
            tall[0] = x;
            size++;
            return;
        }
        int posisjon = (int)Math.floor((size+1)/2);
        int i = size;
        while(i>=posisjon){
            tall[i] = tall[i-1];
            i--;
        }
        tall[posisjon] = x;
        size++;
    }


    public int get(int index){
        return tall[index];
    }

    public void handleInput(String input){
        int data = Integer.parseInt(input.substring(input.length() - 1));
        String command = input.substring(0,input.length()-2);

        if(command.equals("push_back")){
            push_back(data);
            return;
        }
        if(command.equals("push_front")){
            push_front(data);
            return;
        }
        if(command.equals("push_middle")){
            push_middle(data);
            return;
        }
        if(command.equals("get")){
            output.add(get(data));
            return;
        }
    }

    public ArrayList<Integer> getOutput(){
        return output;
    }


}
