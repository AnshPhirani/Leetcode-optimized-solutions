class Solution {
    
    private double calculateGain(double passes, double totalStudents) {
        return (
            (double) (passes + 1) / (totalStudents + 1) -
            (double) passes / totalStudents
        );
    }
    
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        for(int[] c : classes){
            double passes = c[0], totalStudents = c[1];
            double gain = calculateGain(passes, totalStudents);
            pq.add(new double[]{gain, passes, totalStudents});
        }
        
        while(extraStudents-- > 0){
            double[] current = pq.poll();
            double passes = current[1], totalStudents = current[2];
            double updatedGain = calculateGain(passes+1, totalStudents+1);
            pq.add(new double[]{updatedGain, passes+1, totalStudents+1});
        }
        
        double totalPassRatio = 0;
        while(!pq.isEmpty()){
            double[] current = pq.poll();
            double passes = current[1], totalStudents = current[2];
            totalPassRatio += passes/totalStudents;
        }
        
        return totalPassRatio / classes.length;
        
    }
}
