import unittest


class MyTestCase(unittest.TestCase):

#     71
# ms
# Beats
# 54.03%
# of users with Python3
    def minimumLength(self, s: str) -> int:
        l = 0
        r = len(str)-1
        while l < r:
            if s[l] != s[r]:
                return r-l+1
            while l < r and s[l] == s[l+1]:
                l += 1
            while l < r and s[r] == s[r-1]:
                r -= 1
            l += 1
            r -= 1
        diff = r-l
        if diff >= 0:
            return diff+1
        else:
            return 0


    def test_something(self):
        self.assertEqual(2, self.minimumLength("ca"))  #TODO figure out unit testing in python
        self.assertEqual(True, False)  # add assertion here


if __name__ == '__main__':
    unittest.main()
