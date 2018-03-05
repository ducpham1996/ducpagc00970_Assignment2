

public class LSD_Sort {

	public static void main(String[] args) {
		String[] a = { "158", "124", "238", "707", "608", "250", "888" };
		sort(a, 3);
		for (String cha : a) {
			System.out.println(cha);
		}
	}

	private static void sort(String[] a, int w) {
		 // extend ASCII alphabet size
		int R = 256;
		int N = a.length;
		for (int d = w - 1; d >= 0; d--) {
			int[] count = new int[R + 1];
			//Count frequencies of each letter using key as index
			for (int i = 0; i < N; i++) {
				//System.out.println(a[i].charAt(d));
				count[a[i].charAt(d) + 1]++;
			}
			//Compute frequency cumulates
			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}
			//move records
			String aux[] = new String[N];
			for (int i = 0; i < N; i++) {
				aux[count[a[i].charAt(d)]] = a[i];
				count[a[i].charAt(d)]++;
			}
			System.arraycopy(aux, 0, a, 0, N);
		}

	}

}
