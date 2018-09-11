import java.util.Scanner;

public class ExecucaoDosAlgoritmos{
    /*********************************************************************************
     * Método main
    *********************************************************************************/
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Argumentos a mais ou a menos foram passados." +
                " A chamada correta seria --> \"java MinhaClasse NumeroDoAlgoritmoAExecutar QuantidadeDeElementosNaEntrada < ArquivoDeEntrada\"");		
		
            return;		
	}
        
        int algoritmo_a_executar = Integer.parseInt(args[0]);
        int num_elementos_entrada = Integer.parseInt(args[1]);
	   	
	Scanner input = new Scanner(System.in);

	int entrada[] = new int[num_elementos_entrada];
        
        
	for(int i = 0; i < num_elementos_entrada; i++){
            entrada[i] = input.nextInt();
	}
        
	switch(algoritmo_a_executar){
            case 1:
                System.out.println("---------------------------- \n Executando CountSort \n----------------------------");
                CountingSort couting = new CountingSort();
                int output[] = couting.countingSort(entrada);
                for(int j = 0; j < output.length; j++) {
                    System.out.println(output[j]);
                }
                break;
            case 2:
                System.out.println("---------------------------- \n Executando BucketSort \n----------------------------");
                BucketSort bucket = new BucketSort();
                bucket.bucketSort(entrada);
                for (int j = 0; j<num_elementos_entrada; j++) {
                    System.out.println(entrada[j]);
                }
                break;
            case 3:
                System.out.println("---------------------------- \n Executando RadixSort \n----------------------------");
                RadixSort radix = new RadixSort();
                radix.radixSort(entrada,entrada.length);
                for (int j = 0; j<num_elementos_entrada; j++) {
                    System.out.println(entrada[j]);
                }
                break; 
        }
    }

}
