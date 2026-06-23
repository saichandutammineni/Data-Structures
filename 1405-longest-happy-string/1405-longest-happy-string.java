class Node{
    char ch;
    int count;

    public Node(char ch, int count){
        this.ch=ch;
        this.count=count;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Node> pq=new PriorityQueue<>((n1,n2)-> {return n2.count-n1.count;});

        if(a>0){
        pq.offer(new Node('a', a));
        }
        if(b>0){
        pq.offer(new Node('b', b));
        }
        if(c>0){
            pq.offer(new Node('c', c));
        }

        StringBuilder sb=new StringBuilder();



        while(!pq.isEmpty()){
            if(sb.length()>1 && sb.charAt(sb.length()-1)==sb.charAt(sb.length()-2) && sb.charAt(sb.length()-1)==pq.peek().ch){
                Node temp=pq.poll();
                if(pq.isEmpty()){
                    break;
                }
                Node next=pq.poll();
                sb.append(next.ch);
                pq.offer(temp);
                if(next.count-1>0)
                pq.offer(new Node(next.ch, next.count-1));
            }
            else{
                Node next=pq.poll();
                sb.append(next.ch);
                if(next.count-1>0)
                pq.offer(new Node(next.ch, next.count-1));
            }
        }

        return sb.toString();
    }
}