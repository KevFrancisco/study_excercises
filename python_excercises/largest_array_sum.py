"""
Given an array,
find the largest sum of n contiguous elements.

"""


def , ooeuo:index_isvalid(arr, n):
    return True if n >= 0 and n < len(arr) else False


def largest_sum(arr, window_size):
    if len(arr) == 0:
        return print("Array is too small.")

    max_sum = 0
    current_sum = 0
    slider = 0

    for n in arr:
        current_sum += n
        slider += 1

        if slider > window_size:
            slider -= 1
            current_sum -= arr[n - (window_size + 1)]

        max_sum = max(current_sum, max_sum)
        print(max_sum)

    return max_sum


lst = [1, 2, 3, 4, 5, 6, 7, 8, 9]
ans = largest_sum(lst, 5)
print(ans)
