function solution(s) {
    let arr = [];

    for (let i = 0; i < s.length; i++) {
        if (s[i] == '(') {
            arr.push('(');
        } else if (s[i] === ')') {
            if (arr.length === 0) {
                return false;
            } else {
                arr.pop();
            }
        }
    }

    return arr.length == 0;
}