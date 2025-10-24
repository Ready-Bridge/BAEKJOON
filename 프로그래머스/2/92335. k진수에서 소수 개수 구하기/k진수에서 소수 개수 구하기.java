class Solution {
    
    int n, k;
    
    boolean isPrime(long num) {
        
        if(num < 2) {
            return false;
        }
        
        for(long i = 2; i <= (long) Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    String changeNumber() {
        StringBuilder sb = new StringBuilder();
        
        while(n != 0) {
            sb.append(n % k);
            n /= k;
        }
        
        
        return sb.reverse().toString();
    }
    
    public int solution(int n, int k) {
        
        
        int answer = 0;
        this.n = n;
        this.k = k;
        
        String number = changeNumber();
        
        String[] arr = number.split("0");
        
        for(String s : arr) {
            
            if(s.equals("")) continue;
            
            if(isPrime(Long.parseLong(s))) {
                answer++;
            }
        }
        
        return answer;
    }
}