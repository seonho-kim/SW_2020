import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static final int MAX = 1000*1000 + 1;
	static int N;
	static int[] d = new int[100001];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		Arrays.fill(d, 0, N+1, MAX);
		d[1] = 0;
		for (int i = 2; i <= N; i++) {
			if (i % 3 == 0) d[i] = Math.min(d[i], d[i/3] + 1);
			if (i % 2 == 0) d[i] = Math.min(d[i], d[i/2] + 1);
			d[i] = Math.min(d[i], d[i-1] + 1);
		}
		bw.write(d[N] + "");
		bw.flush();
	}
}
//1로 만들기 - 09:54.52