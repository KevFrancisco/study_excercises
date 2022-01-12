def anagram2(s1, s2):

    s1 = s1.replace(" ", "").lower()
    s2 = s2.replace(" ", "").lower()

    # Check if both strings are the same length
    if len(s1) != len(s2):
        return False

    # Hash map time
    lcount = dict()

    for letter in s1:
        if letter not in lcount:
            lcount[letter] = 1
        else:
            lcount[letter] += 1

    for letter in s2:
        if letter not in lcount:
            lcount[letter] = 1
        else:
            lcount[letter] -= 1

    for k in lcount:
        if k != 0:
            return False

    return True


x = anagram2("abcdea", "abcdea")
print(x)
