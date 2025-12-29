class Solution {
    Map<String, List<Character>> childs = new HashMap<>();
    Set<String> bad = new HashSet<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String cur : allowed) {
            String key = cur.substring(0, 2);
            childs.computeIfAbsent(key, k -> new ArrayList<>())
                  .add(cur.charAt(2));
        }

        for (int i = 0; i < bottom.length() - 1; i++) {
            if (!childs.containsKey(bottom.substring(i, i + 2)))
                return false;
        }

        return isPossible(0, bottom, new StringBuilder());
    }

    boolean isPossible(int i, String cur, StringBuilder next) {
        if (i == cur.length() - 1) {
            if (next.length() == 1) return true;

            String row = next.toString();
            if (bad.contains(row)) return false;

            boolean ok = isPossible(0, row, new StringBuilder());
            if (!ok) bad.add(row);
            return ok;
        }

        String key = "" + cur.charAt(i) + cur.charAt(i + 1);
        if (!childs.containsKey(key)) return false;

        for (char ch : childs.get(key)) {
            next.append(ch);
            if (isPossible(i + 1, cur, next)) return true;
            next.deleteCharAt(next.length() - 1);
        }
        return false;
    }
}
