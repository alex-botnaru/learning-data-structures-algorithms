

# Neet code probjem statements

## Arrays & Hashing

### 1. Contains Duplicate
Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

 

**Example 1:**
```
Input: nums = [1,2,3,1]
Output: true
```

**Example 2:**

```
Input: nums = [1,2,3,4]
Output: false
```

**Example 3:**
```
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
```

**Constraints:**
```
1 <= nums.length <= 105
-109 <= nums[i] <= 109
```

### 2. Valid Anagram

Given two strings `s` and `t`, return true if `t` is an anagram of `s`, and false otherwise.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 
**Example 1:**
```
Input: s = "anagram", t = "nagaram"
Output: true
```

**Example 2:**
```
Input: s = "rat", t = "car"
Output: false
```

**Constraints:**
- `1 <= s.length, t.length <= 5 * $10^4$`
- `s` and `t` consist of lowercase English letters.


**Follow up:** What if the inputs contain Unicode characters? How would you adapt your solution to such a case?