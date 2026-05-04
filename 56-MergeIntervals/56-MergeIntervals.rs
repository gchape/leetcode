// Last updated: 5/4/2026, 8:39:39 PM
1impl Solution {
2    pub fn str_str(haystack: String, needle: String) -> i32 {
3        let h = haystack.as_bytes();
4        let n = needle.as_bytes();
5
6        if n.len() == 0 {
7            return 0;
8        }
9
10        if n.len() > h.len() {
11            return -1;
12        }
13
14        for i in 0..=h.len() - n.len() {
15            let mut match_found = true;
16
17            for j in 0..n.len() {
18                if h[i + j] != n[j] {
19                    match_found = false;
20                    break;
21                }
22            }
23
24            if match_found {
25                return i as i32;
26            }
27        }
28
29        -1
30    }
31}