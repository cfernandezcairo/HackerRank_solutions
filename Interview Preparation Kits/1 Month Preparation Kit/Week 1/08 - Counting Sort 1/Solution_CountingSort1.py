#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'countingSort' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def countingSort_ankit_jnvm_2012(arr):
    # Write your code here
    res=[]
    for i in range(0,100):
        res.append(0)
    
    for j in range(len(arr)):
        res[arr[j]]+=1
    
    return a

def countingSort_matt558(arr):
    # Write your code here
    res = [ 0 for x in range(0,100)]

    for i in arr: 
        res[i] += 1
    
    return res

if __name__ == '__main__':
    fptr = sys.stdout

    n = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = countingSort_matt558(arr)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()