class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);
        
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++) freeRooms.add(i);
        
        // {endTime, roomNo}
        PriorityQueue<int[]> meetingRooms  = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        int[] meetingCount = new int[n];
        
        for(int[] meeting : meetings){
            int startTime = meeting[0];
            int endTime = meeting[1];
            while(!meetingRooms.isEmpty() && meetingRooms.peek()[0] <= startTime){
                int roomNo = meetingRooms.poll()[1];
                freeRooms.add(roomNo);
            }
            
            if(!freeRooms.isEmpty()){
                int roomNo = freeRooms.poll();
                meetingRooms.add(new int[]{endTime, roomNo});
                meetingCount[roomNo]++;
            }
            else{
                int newStart = meetingRooms.peek()[0];
                int newEnd = newStart + endTime - startTime;
                int roomNo = meetingRooms.poll()[1];
                meetingRooms.add(new int[]{newEnd, roomNo});
                meetingCount[roomNo]++;
            }
        }
        
        int maxMeetings = 0, ans = 0;
        for(int i = 0; i < n; i++){
            if(meetingCount[i] > maxMeetings){
                maxMeetings = meetingCount[i];
                ans = i;
            }
        }
        
        return ans;
        
    }
}