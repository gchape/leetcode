// Last updated: 8/23/2026, 12:08:33 AM
/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function(n) {
    let result = "1";

    for (let i = 1; i < n; i++) {
        let next = "";
        let j = 0;

        while (j < result.length) {
            let k = j;

            while (k < result.length && result[k] === result[j]) {
                k++;
            }

            next += (k - j) + result[j];
            j = k;
        }

        result = next;
    }

    return result;
};