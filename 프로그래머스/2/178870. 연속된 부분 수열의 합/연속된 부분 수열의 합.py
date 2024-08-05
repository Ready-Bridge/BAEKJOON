def solution(sequence, k):
    n = len(sequence)
    start, end = n - 1, n - 1
    total = sequence[start]
    min_len = float('inf')
    result = [0, 0]

    while end >= 0:
        if total == k:
            if start - end <= min_len:
                min_len = start - end
                result = [end, start]

            end -= 1
            if end >= 0:
                total += sequence[end]
            
            
        
        elif total < k:

            end -= 1
            if end >= 0:
                total += sequence[end]
        else:

            total -= sequence[start]
            start -= 1

    return result