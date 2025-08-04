class Solution {
    public int solution(String s) {
        
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < c.length; i++) {
            if(Character.isDigit(c[i])) {
                sb.append(c[i]);
            } else {
                StringBuilder temp = new StringBuilder();
                while(i < c.length) {
                    
                    if(Character.isDigit(c[i])) {
                        sb.append(c[i]);
                        break;
                    }
                    
                    temp.append(c[i]);
                    i++;
                
                    // -> 쓰면 break 안써도됨
                    switch(temp.toString()) {
                            case "zero" -> {
                                sb.append('0');
                                temp.setLength(0);
                            }
                            case "one" -> {
                                sb.append('1');
                                temp.setLength(0);
                            }
                            case "two" -> {
                                sb.append('2');
                                temp.setLength(0);
                            }
                            case "three" -> {
                                sb.append('3');
                                temp.setLength(0);
                            }
                            case "four" -> {
                                sb.append('4');
                                temp.setLength(0);
                            }
                            case "five" -> {
                                sb.append('5');
                                temp.setLength(0);
                            }
                            case "six" -> {
                                sb.append('6');
                                temp.setLength(0);
                            }
                            case "seven" -> {
                                sb.append('7');
                                temp.setLength(0);
                            }
                            case "eight" -> {
                                sb.append('8');
                                temp.setLength(0);
                            }
                            case "nine" -> {
                                sb.append('9');
                                temp.setLength(0);
                            }
                    } 
                }
            }
        }
        
        return Integer.valueOf(sb.toString());
    }
}