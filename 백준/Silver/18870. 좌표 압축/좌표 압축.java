import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;

import java.util.StringTokenizer;


public class Main {

	public static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		StringTokenizer st = new StringTokenizer(bf.readLine());

		int [] arr = new int[n];
		int [] sortedArr = new int[n];
		int [] result = new int[n];

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.arraycopy(arr, 0, sortedArr, 0, n);

		Arrays.sort(sortedArr);

		for(int i = 0; i < n; i++) {
			if(!map.containsKey(sortedArr[i])) {
				map.put(sortedArr[i], map.size());
			}
		}

		for(int i = 0; i < n; i++) {
			result[i] = map.get(arr[i]);
		}

		for(int i = 0; i < n; i++) {
			bw.write(String.valueOf(result[i]) + " ");
		}

		bw.close();

	}
}

