// Last updated: 8/19/2026, 11:43:34 AM
1class Solution {
2
3    public List<String> restoreIpAddresses(String s) {
4        List<String> result = new ArrayList<>();
5        addAllIpAddresses(result, new ArrayList<>(), s, 0);
6        return result;
7    }
8
9    private void addAllIpAddresses(
10            List<String> result,
11            List<String> ipAddress,
12            String s,
13            int start) {
14
15        if (start == s.length() && ipAddress.size() == 4) {
16            result.add(String.join(".", ipAddress));
17            return;
18        }
19
20        if (ipAddress.size() == 4) {
21            return;
22        }
23
24        for (int i = start; i < start + 3 && i < s.length(); i++) {
25            String part = s.substring(start, i + 1);
26
27            if (part.length() > 1 && part.charAt(0) == '0')
28                break;
29
30            if (Integer.parseInt(part) > 255)
31                break;
32
33            ipAddress.add(part);
34
35            addAllIpAddresses(result, ipAddress, s, i + 1);
36
37            ipAddress.removeLast();
38        }
39    }
40}