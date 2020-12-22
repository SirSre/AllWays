import java.util.*;

public class FieldAdmin {
    private int xMax;
    private int yMax;

    private int result;
    public Stack<Field> stack = new Stack<>();

    private String readString() {
        String result;
        Scanner sc =  new Scanner(System.in);
        result = sc.nextLine();
        return result;
    }

    private int readInt() {
        int result;
        try {
            result = Integer.decode(readString());
        } catch (NumberFormatException e) {
            result = -1;
        }

        return result;
    }

    public void start(){
        Field h = new Field(0,0);
        System.out.println("Enter your max x Value: ");
        this.xMax = readInt();
        System.out.println("Enter your max y Value: ");
        this.yMax = readInt();
        int f = allWays(h);
        System.out.println(f);
    }

    private int allWays(Field h){

        if(h.getX() == this.xMax && h.getY()== this.yMax){
            result++;
        } else if (h.getX() <= this.xMax && h.getY() <= this.yMax){
            stack.push(new Field(h.getX()+1, h.getY()));
            stack.push(new Field(h.getX(), h.getY()+1));
        }
       if(!stack.empty()){
           allWays(stack.pop());
       }
        return result;
    }
}
