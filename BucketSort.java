public class BucketSort {	
    public static void bucketSort(int[] entrada) {
	int maiorvalor = entrada[0];
    	
	for(int j = 1 ; j < entrada.length;j++) {
            if(entrada[j] > maiorvalor)
            maiorvalor = entrada[j];
    	}

	int [] auxiliar = new int[maiorvalor+1];
	 		 	
	for(int i=0; i < auxiliar.length; i++) {
            auxiliar[i]=0;
        }
	 
        for(int i=0; i < entrada.length; i++) {
            auxiliar[entrada[i]]++;
        }
	 
        int outPos=0;
        for(int i=0; i < auxiliar.length; i++) {
            for(int j=0; j<auxiliar[i]; j++) {
                entrada[outPos++]=i;
            }
        }
    }

}
