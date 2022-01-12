""" 

Common Eelements in two sorted Arrays:
Given 2 Arrays, return the common elements as an array

"""


def common_elements(arr1, arr2):
    output = []

    for el in arr1:
        if el in arr2:
            output.append(el)

    return sorted(output)


arr1 = [1, 2, 3, 4, 5, 6, 7, 8, 9]
arr2 = [2, 4, 6, 8]
arr3 = [1, 3, 4, 6, 7, 9]
arr4 = [1, 2, 4, 5, 9, 10]

ans = common_elements(arr1, arr2)
ans2 = common_elements(arr3, arr4)
print(ans)
print(ans2)
