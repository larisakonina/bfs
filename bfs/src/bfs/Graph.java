
package bfs;

import java.util.List;
import java.util.Set;

/**
 * author Лариса Конина
 * гр. 23501/3
 */
public interface Graph {
    interface Vertex {
        String getName();
    }
    
    List<Vertex> getVertices();
    
    Set<Vertex> getNeighbors(Vertex v);
    
    // Optional, for weighted graph
    interface Edge {
        int getWeight();
    }
    
  //  Map<Vertex, Edge> getConnections(Vertex v);
}
