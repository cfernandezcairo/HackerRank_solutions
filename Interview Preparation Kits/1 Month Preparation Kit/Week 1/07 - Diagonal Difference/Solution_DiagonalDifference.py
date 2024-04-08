#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'diagonalDifference' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY arr as parameter.
#

import numpy as np

def diagonalDifferenceNP(arr):

    print('Matrix: ', arr)

    d = np.asarray(arr)
    print('Diagonal (sum): ', np.trace(d))
    print('Diagonal (elements): ', np.diagonal(d))

    ## Array AntiDiagona
    ad = np.fliplr(d)
    print('Antidiagonal (sum): ', np.trace(ad))
    print('Antidiagonal (elements): ', np.diagonal(ad))

    return abs(np.trace(d) - np.trace(ad))

def diagonalDifference(arr):
    # Write your code here
    sumLeftD = sumRightD = it = 0

    arrL = len(arr[it])
    if arrL == 1: return arr[0][0]

    for l in arr:
        sumLeftD+=l[it]
        sumRightD+=l[arrL - it -1]
        it = it + 1

    return abs(sumLeftD - sumRightD)

if __name__ == '__main__':
    fptr = sys.stdout

    n = int(input().strip())

    arr = []

    for _ in range(n):
        arr.append(list(map(int, input().rstrip().split())))

    result = diagonalDifference(arr)

    fptr.write(str(result) + '\n')

    result = diagonalDifferenceNP(arr)

    fptr.write(str(result) + '\n')

    fptr.close()