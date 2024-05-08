import unittest

#     71
# ms
# Beats
# 54.03%
# of users with Python3


def minimum_length(s: str) -> int:
    left = 0
    right = len(str)-1
    while left < right:
        if s[left] != s[right]:
            return right-left+1
        while left < right and s[left] == s[left+1]:
            left += 1
        while left < right and s[right] == s[right-1]:
            right -= 1
        left += 1
        right -= 1
    diff = right-left
    if diff >= 0:
        return diff+1
    else:
        return 0


class MyTestCase(unittest.TestCase):

    def test_something(self):
        self.assertEqual(2, minimum_length("ca"))  # TODO figure out unit testing in python
        self.assertEqual(True, False)  # add assertion here


if __name__ == '__main__':
    unittest.main()
