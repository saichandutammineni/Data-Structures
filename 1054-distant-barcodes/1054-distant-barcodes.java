class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] freq=new int[10001];
        int maxFreqNumber=0;
        for(int i:barcodes){
            freq[i]++;
            if(freq[maxFreqNumber]<freq[i]){
                maxFreqNumber=i;
            }
        }

        int index=0;
        while(freq[maxFreqNumber]-->0){
            // if(index>=barcodes.length){
            //     index=1;
            // }
            barcodes[index]=maxFreqNumber;
            index+=2;
        }

        for(int i=0;i<10001;i++){
            while(freq[i]>0){
                if(index>=barcodes.length){
                    index=1;
                }
                barcodes[index]=i;
                freq[i]--;
                index+=2;
            }
        }


        return barcodes;
    }
}