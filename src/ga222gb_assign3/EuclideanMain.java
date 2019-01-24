package ga222gb_assign3;

public class EuclideanMain {

    public static void main(String[] args){
        System.out.println(euclidean(9, 28));
    }

    public static int euclidean(int m, int n){
        if(n == 0)
            return m;
        return euclidean(n, m % n);
    }
}
