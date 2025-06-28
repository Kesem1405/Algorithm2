 חלק 1 – סיווג קשתות (DFS Edge Classification)


GraphEdgeClassification g = new GraphEdgeClassification(6);
g.addEdge(0, 1);
g.addEdge(0, 2);
g.addEdge(1, 3);
g.addEdge(3, 4);
g.addEdge(4, 1); // Back Edge
g.addEdge(2, 4);
g.addEdge(2, 5);


פלט צפוי  : 
Edge 0->1 is a Tree Edge
Edge 1->3 is a Tree Edge
Edge 3->4 is a Tree Edge
Edge 4->1 is a Back Edge
Edge 0->2 is a Tree Edge
Edge 2->4 is a Cross Edge
Edge 2->5 is a Tree Edge

Times:
Vertex 0: d = 1, f = 14
Vertex 1: d = 2, f = 9
Vertex 2: d = 10, f = 13
Vertex 3: d = 3, f = 8
Vertex 4: d = 4, f = 7
Vertex 5: d = 11, f = 12
_______________________________________________________________________________________________________________________________________________


 חלק 2 – בדיקת גרף קשיר למחצה (Semi-Connected Graph)
קלט : 
SemiConnectedGraph g = new SemiConnectedGraph(4);
g.addEdge(0, 1);
g.addEdge(1, 2);
g.addEdge(2, 3)


פלט : 
Is the graph semi-connected? true


דוגמה נגדית : 
SemiConnectedGraph g = new SemiConnectedGraph(3);
g.addEdge(0, 1);
g.addEdge(2, 0);
פלט צפוי : 
Is the graph semi-connected? false

