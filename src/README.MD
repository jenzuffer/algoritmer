Defend the choice of datastructure with regard of time and space com-plexity (big O):

A diijkstra algorithm can by default not be O(n), its time complexecity is heavier. The complexity must relate to our 
adjacent calls returning related edges, because of this it cant be O(1) or O(n). The marked boolean array 
prevents the queue from reaching o(n^2) however. It is important to note that we use a default java priority queue 
and hence our run time is performing worse. 

Diijkstra space complexity is based on the usage of several hashmaps in our instance. we run 3 linkedHashMaps for 
evaluating distance and other 3 in regards to time. Each Hashmap goes until n elements so we assume its something 
along of O(n). We also have to think about vertices and edges and logerithm. In Diijstrka once we visited a node
its not reachable anymore except for the remaining edges. So something like O(v,e * (v/e)) where for each visited 
vertice there are related edges that may go to unvisted vertices and the edges from there might point to 
remaining vertices that are not visited or point to visited nodes. Hoever already visited nodes may not be passed
again. So for each visited vertice will each related edge come through until all vertices were visited.