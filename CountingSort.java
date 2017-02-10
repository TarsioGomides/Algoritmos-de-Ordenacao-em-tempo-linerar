public class CountingSort {
	private static int getMaiorElemento (int[] entrada, int inicio, int fim) {
		int indice = -1;
        int max = Integer.MIN_VALUE;
        for (int i = inicio; i < fim; ++i) {
        	if (entrada[i] > max) { 
            	max = entrada[i]; 
                indice = i;    
            }
        }

        return indice;
     }

    private static int getMenorElemento (int[] entrada, int inicio, int fim) {
		int indice = -1;
        int min = Integer.MAX_VALUE;
        for (int i = inicio; i < fim; ++i) {
        	if (entrada[i] < min) { 
            	min = entrada[i];
                indice = i;
            }
        }
         
		return indice;
     }

    public static void countingSort(int entrada[]) {
		int menor = entrada[getMenorElemento(entrada, 0, entrada.length)];  
        int maior = entrada[getMaiorElemento(entrada, 0, entrada.length)];
        int j = 0;
        int n = entrada.length;
        int output[] = new int[n]; 
        int count[] = new int[maior-menor+1];
        int c = count.length;
        
        for (int i=0; i<c; ++i) {
            count[i] = 0;
        }
        
        for (int i=0; i < n; i++) {
            count[entrada[i]-menor]++;
        }
        
        for (int i=1; i<=c-1; i++) {
            count[i] += count[i-1];
        }
      
        for (int i = 0; i < c; i++)
            while (j < count[i])
                entrada[j++] = i + menor;      
     }
      
} 
