function solution(s) {
    
    let s2 = s.split(" ");
    
    let min = s2[0];
    let max = s2[0];
    
    s2.forEach(a => {
        a = +a;
        if(a < min) {
            min = a;
        }
        
        if(a > max) {
            max = a;
        }
    });
    
    return `${min} ${max}`;
}