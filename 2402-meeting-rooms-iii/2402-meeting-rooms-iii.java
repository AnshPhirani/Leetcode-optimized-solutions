class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++) availableRooms.add(i);

        int[] meetingCount = new int[n];

        PriorityQueue<int[]> onGoingMeetings = new PriorityQueue<>((a, b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]); // [endTime, roomNo]
        int curTime = 0;
        for(int[] meeting : meetings){
            while(!onGoingMeetings.isEmpty() && onGoingMeetings.peek()[0] <= meeting[0]){
                int roomNo = onGoingMeetings.poll()[1];
                meetingCount[roomNo]++;
                availableRooms.add(roomNo);
            }

            
            if(availableRooms.isEmpty()){
                int[] meetToEnd = onGoingMeetings.poll();
                int roomNo = meetToEnd[1];
                meetingCount[roomNo]++;
                int meetDuration = meeting[1]-meeting[0];
                onGoingMeetings.add(new int[]{meetToEnd[0]+meetDuration, roomNo});

            }
            else{
                int roomNo = availableRooms.poll();
                onGoingMeetings.add(new int[]{meeting[1], roomNo});
            }
        }

        while(!onGoingMeetings.isEmpty()){
            int roomNo = onGoingMeetings.poll()[1];
            meetingCount[roomNo]++;
            availableRooms.add(roomNo);
        }

        int maxMeets = 0;
        for(int count : meetingCount) maxMeets = Math.max(maxMeets, count);
        for(int i = 0; i < n; i++) if(meetingCount[i] == maxMeets) return i;
        return -1;
    }
}