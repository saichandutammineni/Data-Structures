class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n=position.length;
        int[] stack=new int[n];
        double[] mergeTime=new double[n];
        mergeTime[n-1]=Double.POSITIVE_INFINITY;

        int top=n;
        stack[--top]=n-1;
        for(int i=n-2;i>=0;i--){
            boolean merges=false;
            while(top<n){
                int j=stack[top];
                if(position[i+1]-position[i]<=distance){
                    merges=true;
                    break;
                }
                else if(speed[i]<=speed[j]){
                    merges=false;
                    break;
                }

                double time=(double)(position[j]-position[i]-distance)/(speed[i]-speed[j]);

                if(time<=mergeTime[j]){
                    merges=true;
                    mergeTime[i]=time;
                    break;
                }

                top++;
            }

            if(merges) continue;
            stack[--top]=i;
            mergeTime[i] = Double.POSITIVE_INFINITY;
        }

        return n-top;
    }
}