public class CountingSort {
    private static int getIndiceMaiorElemento (int[] entrada, int inicio, int fim) {
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

    public static int[] countingSort(int entrada[]) { 
        int maiorValor = entrada[getIndiceMaiorElemento(entrada, 0, entrada.length)];
        int j = 0;//posição de inserção na saída
        int output[] = new int[entrada.length]; 
        int aux[] = new int[maiorValor+1];
        
        //Preenche o vetor de contagem com zeros (OBS: Essa etapa é desnecessária em java, já que por padrão, ao ser criado, o vetor estará repleto de zeros)
        for (int i=0; i < aux.length; ++i) {
            aux[i] = 0;
        }
        
        //Preenche o vetor de contagem baseado no vetor de entrada
        for (int i=0; i < entrada.length; i++) {//i=0
            aux[entrada[i]] += 1;
        }
        
        //Agora o vetor de contagem vai conter a posição de inserção
        for (int i=1; i < aux.length; i++) {
            aux[i] += aux[i-1];
        }
      
        for (int i = 0; i < entrada.length; i++) {
            output[aux[entrada[i]]-1] = entrada[i];
            aux[entrada[i]] -= 1; 
        }
        
        return output;
    }  
} 
