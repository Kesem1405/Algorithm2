import java.util.*;

public class SemiConnectedGraph {
    private final int V;
    private final List<Integer>[] adj;

    // בנאי – מאתחל גרף עם V צמתים
    public SemiConnectedGraph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();
    }

    // הוספת קשת מ־u ל־v
    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // DFS רגיל – עובר על כל הצמתים שמהם אפשר להגיע מצומת v
    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        for (int u : adj[v]) {
            if (!visited[u])
                dfs(u, visited);
        }
    }

    // פונקציה שבודקת אם יש מסלול דו-כיווני בין u ל־v (אם אחד מהם יכול להגיע לשני)
    private boolean canReachEachOther(int u, int v) {
        boolean[] visited = new boolean[V];
        dfs(u, visited);
        if (visited[v]) return true;

        visited = new boolean[V];
        dfs(v, visited);
        return visited[u];
    }

    // הפונקציה שבודקת אם הגרף הוא קשיר למחצה – כלומר כל שני צמתים מחוברים בכיוון כלשהו
    public boolean isSemiConnected() {
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (u != v && !canReachEachOther(u, v)) {
                    return false;
                }
            }
        }
        return true;
    }

    // פונקציית main שמדגימה את הבדיקה על גרף לדוגמה
    public static void main(String[] args) {
        SemiConnectedGraph g = new SemiConnectedGraph(4);

        // גרף שמדגים קשר חד-כיווני בין כל הצמתים (קשיר למחצה)
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Is the graph semi-connected? " + g.isSemiConnected());
    }
}
