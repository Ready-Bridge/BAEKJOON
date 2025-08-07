class Solution {
    public String solution(String new_id) {
        
        //1
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : new_id.toCharArray()) {
            if(Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        
        new_id = sb.toString();
        
        //2
        
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");    
            
        
        //3
        
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        
        //4
        
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        
        
        //5
        
        if(new_id.length() == 0) {
            new_id = "a";
        }
        
        
        
        //6
        
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        
        if(new_id.endsWith(".")) {
            new_id = new_id.substring(0, 14);
        }
        
        
        
        //7
        if(new_id.length() <= 2) {
            
            sb = new StringBuilder(new_id);
            
            while(sb.length() <= 2) {
                sb.append(sb.charAt(sb.length() - 1));
            }
            
            new_id = sb.toString();
        }
        
        
        return new_id;
    }
}