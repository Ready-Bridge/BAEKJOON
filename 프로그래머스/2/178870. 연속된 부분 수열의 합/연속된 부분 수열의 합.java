class Solution {
	public int[] solution(int[] sequence, int k) {

		int start = 0; // 시작 포인터
		int end = 0; // 끝 포인터
		int sum = sequence[0]; // 첫 원소가 바로 조건을 만족하는 경우를 생각하여 default값을 정해둠
		int[] result = {0, Integer.MAX_VALUE}; // 처음 조건이 맞아서 값을 비교해야한는 경우를 위해 MAX 값을 넣음


		while(end < sequence.length & start <= end) {
			if(sum == k) {

				// 부분 수열의 길이와 시작 index를 고려해서 결과 배열에 저장
				if((end - start) < (result[1] - result[0])) {
					result[0] = start;
					result[1] = end;
				}
				end ++; // 조건을 만족하는 다른 부분 수열을 더 있는지 찾아야 함

				if(end < sequence.length)
					sum += sequence[end];


			} else if(sum > k) { // 현재 부분 수열의 합이 조건보다 큰 경우 왼쪽 포인터 증가 (비내림차순이므로 오른쪽 포인터 증가하면 무조건 커짐)
				sum -= sequence[start++];
			} else { // 현재 부분 수열의 합이 조건보다 작은 경우 오른쪽 포인터를 증가
				end ++;

				if(end < sequence.length)
					sum += sequence[end];
			}
		}
		return result;
	}
}