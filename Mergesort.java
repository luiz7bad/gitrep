import java.util.Arrays;


public class Mergesort {

	private static int copia[];
	private static int entrada[] = {88, 30, 11, 17, 22,1,6,4,2,8,3,0,14,12, 16, 39, 8, 31, 55, 29, 63, 77, 69, 99, 90, 81, 2, 20, 53, 62, 5, 88, 33, 44,1};
	private static int k = 3;

		
	public static void main (String args[])
	{
            //teste
		int x;
		System.out.println("Entrada sem ordenação: " + Arrays.toString(entrada));
		copia = new int[entrada.length];
		mergeSort(0, entrada.length - 1);
		System.out.println("Entrada ordenada: " + Arrays.toString(entrada));
		
		//imprimindo o k-ésimo
		for (x = 0; x <= entrada.length; x++)
			if (x == k)
				System.out.println(entrada[x - 1]);
			
	}
		
	
	private static void mergeSort(int inicio, int fim)
	{
		//dividindo o array na metade
		int meio = (inicio + fim)/2;
		if (inicio < fim)
		{
			//separando do inicio ao meio
			mergeSort(inicio, meio);
		//separando do meio ao fim
			mergeSort(meio + 1, fim);
			merge(inicio, meio, fim);
		}
	}
	
	private static void merge(int inicio, int meio, int fim)
	{
		int iniArray1 = inicio;
		int iniArray2 = meio +1;
				
		for (int i = inicio; i <= fim; i++)
			copia[i] = entrada[i];
		
		while (iniArray2 <= fim && iniArray1 <=meio)
			if (copia[iniArray1] >= copia[iniArray2])
				entrada[inicio++] = copia[iniArray2++];
			else
				entrada[inicio++] = copia[iniArray1++];
		
		while (iniArray1 <= meio)
			entrada[inicio++] = copia[iniArray1++];
		
		while (iniArray2 <= fim)
			entrada[inicio++] = copia[iniArray2++];
				
	}
		
		
			
}
