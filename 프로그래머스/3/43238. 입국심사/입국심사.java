class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long end = (long) n * getMax(times);  

        while (start < end) {
            long mid = (start + end) / 2;

            if (isValid(mid, n, times)) {
                end = mid; 
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean isValid(long t, int n, int[] times) {
        long cnt = 0;
        for (int time : times) {
            cnt += t / time;
            if (cnt >= n) {
                return true;     
            }
        }
        return false;
    }

    private int getMax(int[] times) {
        int max = 0;
        for (int time : times) {
            max = Math.max(max, time);
        }
        return max;
    }
}
