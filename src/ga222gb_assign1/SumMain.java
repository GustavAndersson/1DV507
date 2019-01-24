package ga222gb_assign1;

public class SumMain {

    public static void main(String[] args){
        System.out.println(calcSum(1, 15));
    }

    private static int calcSum(int a, int b){
        int c = (a + b) / 2;
        if(a == b){
            return a;
        }else{
            return calcSum(a, c) + calcSum(c + 1, b);
        }
    }
}


