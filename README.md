# srkInterview

Small Java interview-practice project built with Gradle.

## Included examples

`LongestSubstringExample` solves:

> Given a string, find the length of the longest substring without repeating characters.

It uses a sliding-window approach with a hash map.

- Time complexity: `O(n)`
- Space complexity: `O(min(n, alphabet size))`

`WordBreakExample` solves:

> Given a string and a dictionary of words, determine if the string can be segmented into a space-separated sequence of one or more dictionary words.

It uses dynamic programming with a bounded inner loop based on the longest dictionary word.

- Time complexity: `O(n^2)` in the worst case
- Space complexity: `O(n)`

## Project files

- `src/main/java/com/example/LongestSubstringExample.java` – solution plus a small runnable demo
- `src/main/java/com/example/WordBreakExample.java` – Word Break solution plus a small runnable demo
- `src/test/java/com/example/AppTest.java` – unit tests covering common and edge cases

## Try it

```bash
./gradlew test
./gradlew run
java -cp build/classes/java/main com.example.LongestSubstringExample
java -cp build/classes/java/main com.example.WordBreakExample
```

## Sample cases

- `abcabcbb` -> `3`
- `bbbbb` -> `1`
- `pwwkew` -> `3`
- `abba` -> `2`
- `` -> `0`

## Sample Word Break cases

- `leetcode` with `['leet', 'code']` -> `true`
- `applepenapple` with `['apple', 'pen']` -> `true`
- `catsandog` with `['cats', 'dog', 'sand', 'and', 'cat']` -> `false`

