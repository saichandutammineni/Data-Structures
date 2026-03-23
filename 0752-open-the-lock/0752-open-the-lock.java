class Solution {
    public int openLock(String[] deadends, String target) {
        
        ArrayDeque<String> q=new ArrayDeque<>();
        q.offer("0000");
        HashSet<String> hs=new HashSet<>();
        HashSet<String> visited=new HashSet<>();
        for(String s: deadends){
            hs.add(s);
        }
        if(hs.contains("0000")) return -1;
        if(target.equals("0000")) return 0;
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            count++;
            while(size-->0){
                String s=q.poll();
                
                for (int i = 0; i < 4; i++) {
                    char[] arr = s.toCharArray();
                    char ch = arr[i];

                    // move forward
                    arr[i] = (char) ((ch - '0' + 1) % 10 + '0');
                    String next = new String(arr);

                    if (!hs.contains(next) && !visited.contains(next)) {
                        if (next.equals(target)) return count;
                        q.offer(next);
                        visited.add(next);
                    }

                    // move backward
                    arr = s.toCharArray(); // reset
                    arr[i] = (char) ((ch - '0' + 9) % 10 + '0');
                    next = new String(arr);

                    if (!hs.contains(next) && !visited.contains(next)) {
                        if (next.equals(target)) return count;
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
        }

        return -1;
    }
}