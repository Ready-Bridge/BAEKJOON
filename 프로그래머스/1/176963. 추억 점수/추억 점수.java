class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] result = new int[photo.length];
        
        for(int i = 0 ; i < photo.length; i++) {
            for(String j : photo[i]) {
                
                for(int k = 0; k < name.length; k++) {
                    if(name[k].equals(j)) {
                        result[i] += yearning[k];
                    }
                }
            }
        }
        
        return result;
    }
}