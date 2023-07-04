while True :
    a = b = c = d = 0

    try :
        arr = list(input())
        
        for i in arr :
            if i.islower() :
                a += 1
            elif i.isupper() :
                b += 1
            elif i.isdigit() :
                c += 1
            elif i == " " :
                d += 1
        
        print(str(a) + " " + str(b) + " " + str(c) + " " + str(d))

    except EOFError :
        break