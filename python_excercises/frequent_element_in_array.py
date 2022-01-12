"""

Given an array, what is the most frequently occuring element

"""


def most_frequent(list):
    count = {}
    max_count = 0
    max_item = None

    for i in list:
        if i not in count:
            count[i] = 1
        else:
            count[i] += 1

        if count[i] > max_count:
            max_count = count[i]
            max_item = i

    return max_item


list = [1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5]
ans = most_frequent(list)
print(ans)
