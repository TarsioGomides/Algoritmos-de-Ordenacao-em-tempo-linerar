import java.util.Arrays;
import java.util.Random;

public class HeapSort {    
    private static int tamanho;
  
    //Reorganiza a arvore, para que sempre seja uma HeapMax
    public static void maxHeapify(int[] vetor, int pai) {
        int esq = 2 * pai + 1;
        int dir = 2 * pai + 2; 
        int maior = pai;
        
        if (esq <= tamanho && vetor[esq] > vetor[maior]) { //analisa se o filho da esq é maior que o pai para decidir sobre a troca
            maior = esq;
        }
        
        if (dir <= tamanho && vetor[dir] > vetor[maior]) { //analisa se o filho direito é maior que o pai para decidir sobre a troca
         	  maior = dir;
        }
        if (maior != pai) {
            int aux = vetor[pai];
            vetor[pai] = vetor[maior];
            vetor[maior] = aux;
            maxHeapify(vetor, maior);
        }
    }

    //Torna a arvore uma HeapMax inicialmente
    public static void criaHeapMax(int[] vetor) {
        tamanho = vetor.length - 1;
        for (int pai = tamanho / 2; pai >= 0; pai--) {
            maxHeapify(vetor, pai);
        }
    }

    public static void heapSort(int[] vetor) {
        criaHeapMax(vetor);
        for (int i = tamanho; i > 0; --i) {
            int aux = vetor[i];
            vetor[i] = vetor[0];
            vetor[0] = aux;
            tamanho--;//Diminui o tamanho da arvore
            maxHeapify(vetor, 0); //Vai tornar novamente a arvore uma heapmax
        }
    }
}
