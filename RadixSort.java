public class RadixSort {
    static int MaxValor(int entrada[], int n) {
        int maiorElemento = entrada[0];
        
        for (int i = 1; i < n; i++)
            if (entrada[i] > maiorElemento)
                maiorElemento = entrada[i];
        
        return maiorElemento;
    }

    static void countingSort(int entrada[], int n, int exp) {
        int output[] = new int[n]; 
        int i;
        int aux[] = new int[10];
        
        for (int j=0; j<aux.length; ++j)
            aux[j] = 0;
        
        for (i = 0; i < n; i++)
            aux[ (entrada[i]/exp)%10 ]++;
 
        for (i = 1; i < 10; i++)
            aux[i] += aux[i - 1];
 
        for (i = n - 1; i >= 0; i--) {
            output[aux[ (entrada[i]/exp)%10 ] - 1] = entrada[i];
            aux[ (entrada[i]/exp)%10 ]--;
        }
 
        for (i = 0; i < n; i++)
            entrada[i] = output[i];
        
    }
 
    public static void radixSort(int entrada[], int n) {
        int maiorElemento = MaxValor(entrada, n);
      
        for (int exp = 1; maiorElemento/exp > 0; exp *= 10)
            countingSort(entrada, n, exp);
    }

}
