package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ������ ������ 
 * ��. 23501/3
 */

public class BfsGraph implements Graph {

    class GraphVertex implements Vertex {
        String name;
        
        public GraphVertex(String name) {
            this.name = name;
        }
        
        
        @Override
        public String getName() {
            return name;
        }
    }
    ArrayList<Vertex> Vertices;       //������������� �����������  ������ ������
    Map<Vertex, Set<Vertex>> VertexNeighbors;   //��������� map ������ ���� (�������) � ���������
    //� ��� �������� (��������� ������-�������)
    public BfsGraph(int count) {
        
       Vertices = new ArrayList();     //������� ������ ������
       VertexNeighbors = new HashMap();  //������� ��������� ������-�������
        
        for (int i = 0; i < count; i++) {
          GraphVertex v;  
          v = new GraphVertex(Integer.toString(i+1));    
          Vertices.add(v);                        //��������� ������ ������ (���-�� = count)
          VertexNeighbors.put(v, new HashSet());  //��� ������ ������� ������� ���������
        }
    }
    

    @Override
    public ArrayList<Vertex> getVertices() {
        return Vertices;
    }
    
    @Override
    public Set<Vertex> getNeighbors(Vertex v) {
        return VertexNeighbors.get(v);
    }
    
    static class Info {
    
        boolean visited;
        int distance;
        Vertex prev;
        
            public Info(boolean visited, int distance, Vertex prev) {
            this.visited = visited;
            this.distance = distance;
            this.prev = prev;
        }
        
        public boolean getVisit() {
            return visited;
        }
        
        public int getDistance() {
            return distance;
        }
        
        public Vertex getPrevious() {
            return prev;
        }
        
    }
    
    public static int bfs (BfsGraph g, Vertex start, Vertex end) {

        ArrayList<Vertex> Vertices = g.getVertices();
        Map<Vertex, Info> VertexInfo = new HashMap();
        
        Vertices.forEach((v) -> {                          //for v in Vertices
            VertexInfo.put(v, new Info(false, 0, null));   //info[v]=(not_visited, prev=null)
        });
        
        VertexInfo.put(start, new Info(true, 0, null));    //info[s]=(visited, prev=null)         
        Deque<Vertex> Queue = new ArrayDeque();
        Queue.add(start);                                  //enqueue(s)
        
        while (!Queue.isEmpty()) {                         //while queue is not empty
             
            Deque<Vertex> newQueue = new ArrayDeque();
            
            for (Vertex u : Queue) {                       //u = dequeue
              Info uInfo = VertexInfo.get(u);
              Set<Vertex> neighbors = g.getNeighbors(u);
              neighbors.forEach((w) -> {                   //for w in neighbors (u)
                  Info info = VertexInfo.get(w);
                    if (info.getVisit() == false) {    //if info[v] not_visited
                      
                        Info newInfo = new Info(true, uInfo.getDistance()+1, u);  //info[w] = visited, prev = u
                        VertexInfo.put(w, newInfo);           //�������� ���������� � w �� ����������
                        newQueue.add(w);                      //��������� w � ����� �������
                    }
                });
            }
            Queue = newQueue;                                  //�������������� �������
        }
        if (VertexInfo.get(end).getVisit() == true) {          //���� ��������� ������� ��������
            return VertexInfo.get(end).getDistance();          
        } 
        return 0;
    }
}