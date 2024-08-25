def read_grid_from_file(file_name):
    with open(file_name, 'r') as file:
        grid = [list(line.strip()) for line in file]
    return grid


def find_start(grid):
    for i in range(len(grid)):
        for j in range(len(grid[i])):
            if grid[i][j] == 'S':
                grid[i][j] = 'a'
                return i, j
    return -1, -1


def traverse(grid, steps, current, visited):
    successful_steps = []
    visited[current[0]][current[1]] = True

    if grid[current[0]][current[1]] == 'E':
        successful_steps.append(steps)
    else:
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        for x, y in directions:
            next_x, next_y = current[0] + x, current[1] + y
            if (0 <= next_x < len(grid) and 0 <= next_y < len(grid[0]) and
                    grid[next_x][next_y] <= chr(ord(grid[current[0]][current[1]]) + 1) and
                    not visited[next_x][next_y]):
                successful_steps.extend(traverse(grid, steps + 1, (next_x, next_y), visited))

    visited[current[0]][current[1]] = False
    return successful_steps


def main():
    file_name = "../../day12input.txt"
    grid = read_grid_from_file(file_name)
    visited = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))]
    start_location = find_start(grid)
    successful_steps = traverse(grid, 0, start_location, visited)

    if successful_steps:
        min_steps = min(successful_steps)
        print(f"Minimum steps: {min_steps}")
    else:
        print("No solution found")


if __name__ == "__main__":
    main()
