"""
Minesweeper!
Function would take 3 arguments:
A list of bomb locations, rows, columns

mine_sweeper([[0,0], [1,2]], 3, 4)

Function must return a correctly sized matrix
where:
    Bomb = X

[
    [ X, 2, 1, 1 ],
    [ 1, 2, X, 1 ],
    [ 1, 1, 1, 1 ],
]

"""


def index_isvalid(row, col, pos):
    r, c = pos
    if r >= 0 and r < row and c >= 0 and c < col:
        return True
    return False


def make_board(num_rows, num_cols):
    board = []
    for i in range(num_rows):
        board.append([])
        for j in range(num_cols):
            board[i].append(0)
    return board


def place_bombs(bombs, num_rows, num_cols, board):
    for bomb in bombs:
        r, c = bomb[0], bomb[1]
        board[r][c] = "X"


def build_neighbors(num_rows, num_cols, pos):
    neighbors = []
    r, c = pos
    r -= 1
    c -= 1

    for i in range(r, r + 3):
        for j in range(c, c + 3):
            new_pos = [i, j]
            if index_isvalid(num_rows, num_cols, new_pos):
                neighbors.append([i, j])
    return neighbors


def mine_sweeper(bombs, num_rows, num_cols):
    visited = set()
    board = make_board(num_rows, num_cols)
    place_bombs(bombs, num_rows, num_cols, board)

    # Place the bomb proximity markers
    for i in range(num_rows):
        for j in range(num_cols):
            pos = (i, j)
            if pos in visited:
                continue
            if board[i][j] != "X":
                continue
            visited.add(pos)

            neighbors = build_neighbors(num_rows, num_cols, pos)
            print(neighbors)
            for neighbor in neighbors:
                if index_isvalid(num_rows, num_cols, neighbor):
                    r, c = neighbor
                    if board[r][c] != "X":
                        board[r][c] += 1

    return board


res = mine_sweeper([[0, 0], [1, 2]], 3, 4)
print("\n".join(map(str, res)))
