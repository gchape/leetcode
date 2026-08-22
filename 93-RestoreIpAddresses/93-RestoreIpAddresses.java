// Last updated: 8/23/2026, 12:08:16 AM
class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        addAllIpAddresses(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void addAllIpAddresses(
            List<String> result,
            List<String> ipAddress,
            String s,
            int start) {

        if (start == s.length() && ipAddress.size() == 4) {
            result.add(String.join(".", ipAddress));
            return;
        }

        if (ipAddress.size() == 4) {
            return;
        }

        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String part = s.substring(start, i + 1);

            if (part.length() > 1 && part.charAt(0) == '0')
                break;

            if (Integer.parseInt(part) > 255)
                continue;

            ipAddress.add(part);

            addAllIpAddresses(result, ipAddress, s, i + 1);

            ipAddress.removeLast();
        }
    }
}