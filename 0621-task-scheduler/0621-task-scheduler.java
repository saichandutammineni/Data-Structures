class Node{
    char ch;
    int freq;

    Node(char ch, int freq){
        this.ch=ch;
        this.freq=freq;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm=new HashMap<>(); 
        for(int i=0;i<tasks.length;i++){
            hm.put(tasks[i], hm.getOrDefault(tasks[i], 0)+1);
        }

        PriorityQueue<Node> maxHeap=new PriorityQueue<Node>((a,b)-> b.freq-a.freq);
        for(Map.Entry<Character,Integer> e: hm.entrySet()){
            maxHeap.offer(new Node(e.getKey(), e.getValue()));
        }
        int ansCount=0;
        while(!maxHeap.isEmpty()){
            Queue<Node> q=new LinkedList<Node>();
            int cycleLen=n+1;
            while(cycleLen>0 && !maxHeap.isEmpty()){
                Node temp=maxHeap.poll();
                cycleLen--;
                
                if(temp.freq>1){
                    temp.freq--;
                    q.offer(temp);
                }


            }
            
            ansCount+=q.size()>0 ? n+1 : n+1-cycleLen;
            while(q.size()>0){
                maxHeap.offer(q.poll());
            }            

        }
        return ansCount;
    }
}