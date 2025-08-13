class Solution {
    public int[] solution(int[][] arr) {
        Point p = count(0, 0, arr.length, arr);
        return new int[] {p.zero, p.one};
    }
    
    // 0과 1의 개수를 세기 위한 클래스
    private static class Point {
        public final int one;
        public final int zero;
        
        public Point(int one, int zero) {
            this.one = one;
            this.zero = zero;
        }
        
        public Point add(Point p) {
            return new Point(one + p.one, zero + p.zero);
        }
    }
    
    private Point count(int x, int y, int size, int[][] arr) {
        int h = size / 2;
        
        for(int i = x; i < x + size; i++) {
            for(int k = y; k < y + size; k++) {
                if(arr[x][y] != arr[i][k]) {
                    return count(x, y, h, arr)
                        .add(count(x + h, y, h, arr))
                        .add(count(x, y + h, h, arr))
                        .add(count(x + h, y + h, h, arr));
                }
            }
        }
        
        if(arr[x][y] == 1) {
            return new Point(1, 0);
        } else {
            return new Point(0, 1);
        }
    }
    
}