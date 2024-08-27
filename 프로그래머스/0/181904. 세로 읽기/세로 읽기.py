def solution(my_string, m, c):
    a=""
    for i in range(len(my_string)//m):
        a+=my_string[m*i+c-1]
    return a