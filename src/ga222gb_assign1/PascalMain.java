package ga222gb_assign1;

public class PascalMain {

    public static void main(String[] args){
        int[] arr = calcRow(6);

        for(int i  = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] calcRow(int rowNumber) {
        int[] row = new int[rowNumber + 1];
        row[0] = 1;
        row[rowNumber] = 1;
        if (rowNumber < 0) {
            throw new IndexOutOfBoundsException();
        } else if (rowNumber == 0) {
            row = new int[] {1};
        } else {
            int[] lastRow = calcRow(rowNumber - 1);
            for (int i = 1; i < rowNumber; i++) {
                row[i] = lastRow[i - 1] + lastRow[i];
            }
        }
        return row;
    }
}
