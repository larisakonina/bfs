
import bfs.BfsGraph;
import bfs.Graph;
import java.util.Map;
import java.util.Set;
import static junit.framework.Assert.assertEquals;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *@author Лариса Конина
 * гр. 23501/3
 */
public class BfsTest {
   
    public void bfsTest() {
         int realdistance, receiveddistance; 
        Map<Graph.Vertex, Set<Graph.Vertex>> VertexNeighbors = null;  
        BfsGraph g;
        BfsGraph.Vertex start, end;
      
        g = new BfsGraph(2);
        

        Set<Graph.Vertex> neighbors = VertexNeighbors.get(g.getVertices().get(0));   
        neighbors.add(g.getVertices().get(1));  
        neighbors =  VertexNeighbors.get(g.getVertices().get(1));   
        neighbors.add(g.getVertices().get(0));
       
        start = g.getVertices().get(0);
        end = g.getVertices().get(1);
        
        realdistance = 1;
        receiveddistance = BfsGraph.bfs(g, start, end);
        
        assertEquals(realdistance, receiveddistance);
        
        
        
        
        g = new BfsGraph(6);

        neighbors = VertexNeighbors.get(g.getVertices().get(0));   
        neighbors.add(g.getVertices().get(1)); 
        neighbors.add(g.getVertices().get(2)); 
        neighbors =  VertexNeighbors.get(g.getVertices().get(1));   
        neighbors.add(g.getVertices().get(0));
        neighbors =  VertexNeighbors.get(g.getVertices().get(2));   
        neighbors.add(g.getVertices().get(0));
        neighbors.add(g.getVertices().get(3));
        neighbors =  VertexNeighbors.get(g.getVertices().get(3));   
        neighbors.add(g.getVertices().get(2));
        
       
        start = g.getVertices().get(0);
        end = g.getVertices().get(3);
        
        realdistance = 2;
        receiveddistance = BfsGraph.bfs(g, start, end);
        
        assertEquals(realdistance, receiveddistance);
        
        
    }
  
  
}
