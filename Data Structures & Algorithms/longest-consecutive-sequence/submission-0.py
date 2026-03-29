class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        store = set()
        for i in nums:
            store.add(i)
        ans = 0
        for num in store:
            if num-1 in store:
                continue
            else:
                next_el = num+1
                count = 1
                while(True):
                    if next_el in store:
                        count+=1
                        next_el+=1
                    else:
                        ans = max(ans, count)
                        break
        return ans