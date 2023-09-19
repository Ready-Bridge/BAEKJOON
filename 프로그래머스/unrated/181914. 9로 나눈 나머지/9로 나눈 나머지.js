function solution(number) {
    let ret = 0;
    
    for(let i = 0; i < number.length; i++) {
        ret += Number(number[i]);
    }
    
    return ret % 9;
}