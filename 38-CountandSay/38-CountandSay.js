// Last updated: 8/19/2026, 12:11:02 PM
1/**
2 * @param {number} n
3 * @return {string}
4 */
5var countAndSay = function(n) {
6    let result = "1";
7
8    for (let i = 1; i < n; i++) {
9        let next = "";
10        let j = 0;
11
12        while (j < result.length) {
13            let k = j;
14
15            while (k < result.length && result[k] === result[j]) {
16                k++;
17            }
18
19            next += (k - j) + result[j];
20            j = k;
21        }
22
23        result = next;
24    }
25
26    return result;
27};