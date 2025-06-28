import java.util.*;

public class GraphEdgeClassification {
    private int time = 0; // משתנה שמשמש כדי לקבוע את זמני הכניסה והיציאה מכל צומת
    private final int V; // מספר הצמתים בגרף
    private final List<Integer>[] adj; // רשימת שכנויות לכל צומת

    // משתנים עבור כל צומת
    private final String[] color; // הצבע של הצומת: white - לא ביקרנו, gray - בתהליך, black - סיימנו
    private final int[] d; // זמן כניסה (discover time)
    private final int[] f; // זמן יציאה (finish time)
    private final Integer[] parent; // האבא של כל צומת ב־DFS

    // בנאי – מאתחל את כל המשתנים ומכין את רשימת השכנויות
    public GraphEdgeClassification(int V) {
        this.V = V;
        adj = new ArrayList[V];
        color = new String[V];
        d = new int[V];
        f = new int[V];
        parent = new Integer[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
            color[i] = "white";
        }
    }

    // פונקציה להוספת קשת מ־u ל־v (קשת מכוונת)
    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // הפונקציה הראשית של DFS – עוברת על כל הצמתים ומפעילה DFS לכל צומת שעדיין לא ביקרנו בו
    public void dfs() {
        for (int u = 0; u < V; u++) {
            if (color[u].equals("white")) {
                dfsVisit(u);
            }
        }
    }

    // הפונקציה שעושה את הביקור בצומת – ומסווגת את הקשתות לפי הסוגים שהמרצה ביקש
    private void dfsVisit(int u) {
        color[u] = "gray";
        d[u] = ++time; // שמירת זמן כניסה

        for (int v : adj[u]) {
            if (color[v].equals("white")) {
                System.out.println("Edge " + u + "->" + v + " is a Tree Edge"); // קשת עץ
                parent[v] = u;
                dfsVisit(v);
            } else if (color[v].equals("gray")) {
                System.out.println("Edge " + u + "->" + v + " is a Back Edge"); // קשת אחורה
            } else {
                if (d[u] < d[v]) {
                    System.out.println("Edge " + u + "->" + v + " is a Forward Edge"); // קשת קדימה
                } else {
                    System.out.println("Edge " + u + "->" + v + " is a Cross Edge"); // קשת חוצה
                }
            }
        }

        color[u] = "black";
        f[u] = ++time; // שמירת זמן יציאה
    }

    // הדפסת זמני d ו־f של כל צומת
    public void printTimes() {
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": d = " + d[i] + ", f = " + f[i]);
        }
    }

    // דוגמה לגרף לצורך הדגמה של הסיווג
    public static void main(String[] args) {
        GraphEdgeClassification g = new GraphEdgeClassification(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1); // קשת אחורה
        g.addEdge(2, 4);
        g.addEdge(2, 5);

        g.dfs();
        System.out.println("\nTimes:");
        g.printTimes();
    }
}
