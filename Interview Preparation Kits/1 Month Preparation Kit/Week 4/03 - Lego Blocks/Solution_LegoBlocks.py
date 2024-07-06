#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'legoBlocks' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER m
#

def legoBlocks(h, w):
    # Write your code here
    modulo = 10**9+7

    row = [ 0 for _ in range(w+1) ]

    if w>=1:
        row[1] = 1
    if w>=2:
        row[2] = 2
    if w>=3:
        row[3] = 4
    if w>=4:
        row[4] = 8
    if w>=5:
        for i in range(5, w+1):
            row[i] = (row[i-1] + row[i-2] + row[i-3] + row[i-4]) % modulo

    total = row.copy()
    for _ in range(2, h+1):
        for i in range(w+1):
            total[i] = (row[i] * total[i]) % modulo

    solid = [ 0 for _ in range(w+1) ]
    solid[1] = 1
    for ww in range(2, w+1):
        unsolid_sum = 0
        for i in range(1, ww):
            unsolid_sum += ((solid[i] * total[ww-i]) % modulo)
        solid[ww] = (total[ww] - unsolid_sum) % modulo

    return solid[w] % modulo

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        result = legoBlocks(n, m)

        fptr.write(str(result) + '\n')

    fptr.close()