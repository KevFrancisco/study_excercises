"""

Array Pair Sum
Given an integer array, output all the unique
pairs thas sum up to a specific value k.

So the input:
    pair_sum([1, 3, 2, 2], 4)
would return 2 pairs:
(1, 3)
(2, 2)

"""


def pair_sum(array, k):
    if len(array) < 2:
        return print("Array too small")

    seen = set()
    output = set()

    for num in array:
        target = k - num

        if target not in seen:
            seen.add(num)
        else:
            res = (min(num, target), max(num, target))
            output.add(res)
    formatted_answer = "\n".join(map(str, list(output)))

    return formatted_answer


# Driver Code
x = pair_sum([1, 3, 2, 2, 3], 4)
print(x)
