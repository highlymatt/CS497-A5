import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {

    public int shortestPathLength(int[][] graph) {
        if(graph.length == 1){
            return 0;
        }
        int endState = (1 << graph.length) - 1;
        // Stores {i, BitState} - BitState ex) out of 4 nodes if nodes 0 & 1 are visited would be 0011
        // {i, BitState} used to check if code is about to get caught in a loop and continually revisit the same two nodes
        Queue<int[]> q = new LinkedList<>();

        // Adding all nodes initially because we can start anywhere
        for(int x = 0; x< graph.length; x++){
            q.add(new int[]{x, 1 << x});
        }
        //[no of many nodes][each node may have 2^n visited bit]
        int [][] visitedMap = new int [graph.length][endState+1];


        int shortestPath = 0;
        while(!q.isEmpty()){
            int size = q.size();
            shortestPath++;
            for(int i=0; i<size; i++){
                int [] head = q.poll();
                int nodeId = head[0];
                int visitedNodeBitState = head[1];
                for(int neighbor : graph[nodeId]){
                    // a | b, will compare both bit values and create a new bit value that both bit's 1's if it exists in either bits position
                    // ex) 0011 | 1010 = 1011
                    int newVisitedNodeBitState = visitedNodeBitState | (1 << neighbor);

                    //If the same node was visited again with same visitedNodeBit, it means this node can be skipped,
                    // For example: 1->0->1->0.  First 1 we have {1, 10}, then we have {0, 11}, then we will have {1, 11}.
                    // Lastly, we have {0, 11} which is a state we already had before. So we don't visit this again.

                    if(visitedMap[neighbor][newVisitedNodeBitState] == 1) {
                        continue;
                    }
                    visitedMap[neighbor][newVisitedNodeBitState] = 1;
                    if(newVisitedNodeBitState==endState) {
                        return shortestPath;
                    }
                    q.add(new int [] {neighbor, newVisitedNodeBitState});
                }
            }
        }
        return -1;
    }


    public static void main(String[] args){
        ShortestPathVisitingAllNodes obj = new ShortestPathVisitingAllNodes();
        int[][] graph = {{1,2,3}, // node 0's neighboring nodes
                        {0},      // node 1's neighboring nodes
                        {0},      // node 2's neighboring nodes
                        {0}};     // node 3's neighboring nodes
        System.out.println(obj.shortestPathLength(graph));
        graph = new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}};
        System.out.println(obj.shortestPathLength(graph));
    }
}
