"""
Given a string,
return the reverse!

Given:
    "This is the best"
Return:
    "best the is This"
"""


def reverse_string(s):
    # Using the inbuilt functions
    # print(s)
    # return " ".join(reversed(s.split()))
    # return " ".join(s.split()[::-1])
    # NOTE: Reversed built-in returns an iterator
    # ready to traverse your obj in the reverse order
    # Meanwhile .reverse() does it in-place

    length = len(s)
    spaces = [" "]
    words = []
    i = 0

    while i < length:
        if s[i] not in spaces:
            word_start = i

            while i < length and s[i] not in spaces:
                i += 1

        words.append(s[word_start:i])

        i += 1

    return " ".join(words[::-1])


sentence = "This is the best"
ans = reverse_string(sentence)
print(ans)
