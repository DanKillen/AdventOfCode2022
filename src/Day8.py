'''
 Created by Dan Killen on 14/01/2023
 How many trees are visible from outside the grid?
 '''
import itertools

with open('day8input.txt', 'r') as f:
    data = tuple(tuple(int(n) for n in line.rstrip()) for line in f)
width = len(data[0])
height = len(data)

visible = [ [ False for _ in data[0] ] for _ in data ]

for row_n in range(height):
    # look from the left
    tallest = -1
    for col_n in range(width):
        if data[row_n][col_n] > tallest:
            tallest = data[row_n][col_n]
            visible[row_n][col_n] = True
    # look from the right
    tallest = -1
    for col_n in reversed(range(width)):
        if data[row_n][col_n] > tallest:
            tallest = data[row_n][col_n]
            visible[row_n][col_n] = True

for col_n in range(width):
    # look from the top
    tallest = -1
    for row_n in range(height):
        if data[row_n][col_n] > tallest:
            tallest = data[row_n][col_n]
            visible[row_n][col_n] = True
    # look from the bottom
    tallest = -1
    for row_n in reversed(range(height)):
        if data[row_n][col_n] > tallest:
            tallest = data[row_n][col_n]
            visible[row_n][col_n] = True

print(sum(itertools.chain.from_iterable(visible)))
