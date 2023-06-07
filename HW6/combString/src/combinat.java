public class combinat {
    char[] curent;
    public combinat(String str) {
        curent=str.toCharArray();
    }
    public void print(){
        printRecursive(curent.length,curent);
    }
    public void printRecursive(int n, char[] elements) {
        if(n == 1) {
            printArray(elements);
        } else {
            for(int i = 0; i < n-1; i++) {
                printRecursive(n - 1, elements);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printRecursive(n - 1, elements);
        }
    }
    private void swap(char[] elements, int a, int b) {
        char tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }
    private void printArray(char[] elements) {
        for(char elm: elements) {
            System.out.print(elm);
        }
        System.out.print('\n');
    }
}
