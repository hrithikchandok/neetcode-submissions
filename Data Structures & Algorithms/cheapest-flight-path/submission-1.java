
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1. Build the adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            // adj stores {destination, price}
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // 2. Initialize the distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // 3. Queue stores {currentNode, currentCost, currentStops}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});

        // 4. Perform BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            // If we've reached the maximum number of stops, don't explore further from this path
            if (stops > k) {
                continue;
            }

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int edgeCost = neighbor[1];

                // If we found a cheaper way to reach nextNode within the stop limit, update and add to queue
                if (cost + edgeCost < dist[nextNode]) {
                    dist[nextNode] = cost + edgeCost;
                    q.add(new int[]{nextNode, dist[nextNode], stops + 1});
                }
            }
        }

        // 5. If dist[dst] is still MAX_VALUE, it means it's unreachable within k stops
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}