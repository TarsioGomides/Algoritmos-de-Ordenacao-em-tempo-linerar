//import java.util.Arrays;

public class RadixSort {
	static int MaxValor(int entrada[], int n) {
		int mx = entrada[0];
        
		for (int i = 1; i < n; i++)
        	if (entrada[i] > mx)
            	mx = entrada[i];
        
		return mx;
    }

	static void countingSort(int entrada[], int n, int exp) {
    	int output[] = new int[n]; 
        int i;
        int count[] = new int[10];
        
        for (int j=0; j<count.length; ++j) {
        	count[j] = 0;
        }

        for (i = 0; i < n; i++)
            count[ (entrada[i]/exp)%10 ]++;
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (i = n - 1; i >= 0; i--) {
            output[count[ (entrada[i]/exp)%10 ] - 1] = entrada[i];
            count[ (entrada[i]/exp)%10 ]--;
        }
 
        for (i = 0; i < n; i++)
            entrada[i] = output[i];
    }
 
    public static void radixSort(int entrada[], int n) {
   		int m = MaxValor(entrada, n);
      
        for (int exp = 1; m/exp > 0; exp *= 10)
			countingSort(entrada, n, exp);
    }

}
