import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import java.util.Scanner;

 // 0 - Alagoas
 // 1 - Bahia
 // 2 - Ceará
 // 3 - Maranhão
 // 4 - Paraíba
 // 5 - Pernambuco
 // 6 - Piauí
 // 7 - Rio Grande do Norte
 // 8 - Sergipe

public class Main {

    public static void main(String[] args) {
     
        In in = new In("Dados/nordeste.txt");
        Graph graph = new Graph(in);
        Scanner sc = new Scanner(System.in);

        System.out.print("Estado de Origem: ");
        int origem = sc.nextInt();
        System.out.print("Estado de Destino: ");
        int destino = sc.nextInt();

        StdOut.println("Origem: " + origem);
        StdOut.println("Destino: " + destino);
        StdOut.println();

        DepthFirstPaths dfs = new DepthFirstPaths(graph, origem);

        if (dfs.hasPathTo(destino)) {
            StdOut.print("Caminho DFS: ");
            for (int v : dfs.pathTo(destino)) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        } else {
            StdOut.println("Não existe caminho (DFS)");
        }

        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, origem);

        if (bfs.hasPathTo(destino)) {
            StdOut.print("Caminho BFS (menor): ");
            for (int v : bfs.pathTo(destino)) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        } else {
            StdOut.println("Não existe caminho (BFS)");
        }

        int count = 0;
        for (int v = 0; v < graph.V(); v++) {
            if (v != origem && dfs.hasPathTo(v)) {
                count++;
            }
        }

        StdOut.println();
        StdOut.println("Estados alcançáveis a partir de " + origem + " (Sem contabilizar a origem): " + count);

        StdOut.println();
        if (dfs.hasPathTo(destino)) {
            StdOut.println("É possível chegar de " + origem + " até " + destino);
        } else {
            StdOut.println("NÃO é possível chegar de " + origem + " até " + destino);
        }
    }
}
