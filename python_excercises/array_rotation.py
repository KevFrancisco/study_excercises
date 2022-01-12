""" 
Given 2 arrays (assume no duplicates)
check if 1 array is a rotation of the other
same size, same elements, but indexes are offset

True:
[1,2,3,4,5]
[4,5,1,2,3]

Select an indexed pos in list 1 and get it's value,
Find same element is list2 and check index from there.

"""


def rotated_array(list1, list2):
    if len(list1) != len(list2):
        return False

    key = list1[0]
    key_offset_counter = None

    # Find the key offset
    for i in range(len(list2)):
        if list2[i] == key:
            key_offset_counter = i
            break

    if key_offset_counter is None:
        return False

    for i in range(len(list1)):
        offsetted_index = (key_offset_counter + i) % len(list1)
        if list1[i] != list2[offsetted_index]:
            return False

    # All guard clauses have been passed, therefore True
    return True


arr1 = [1, 2, 3, 4, 5, 6]
arr2 = [6, 1, 2, 3, 4, 5]


ans = rotated_array(arr1, arr2)
print(ans)
