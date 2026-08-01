// Last updated: 8/1/2026, 11:13:29 PM
impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        let h = haystack.as_bytes();
        let n = needle.as_bytes();

        if n.len() == 0 {
            return 0;
        }

        if n.len() > h.len() {
            return -1;
        }

        for i in 0..=h.len() - n.len() {
            let mut match_found = true;

            for j in 0..n.len() {
                if h[i + j] != n[j] {
                    match_found = false;
                    break;
                }
            }

            if match_found {
                return i as i32;
            }
        }

        -1
    }
}