function solution(food) {
    let a = [];
    let b = [];
    
    
    
    for(let i = 1; i < food.length; i++) {
        for(let v = 0; v < (food[i] / 2) - (food[i] % 2); v++) {
            a.push(i);
            b.push(i);
        
        }
    }
    
    
    
    result = "";
    
    for(let i = 0; i < a.length; i++) {
        result += a[i];
    }
    
    result += "0";
    
    for(let i = b.length - 1; i >= 0; i--) {
        result += b[i];
    }
    
    return result;
    
}