package com.company;

import com.company.classes.Graph;
import com.company.classes.Vertex;

public class Main {

    public static void main(String[] args) {
        Graph myGraph = new Graph(6);
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");
        Vertex vertexX = new Vertex("X");
        myGraph.insertVertex(vertexA);
        myGraph.insertVertex(vertexB);
        myGraph.insertVertex(vertexC);
        myGraph.insertVertex(vertexD);
        myGraph.insertVertex(vertexE);
        myGraph.insertVertex(vertexF);
        myGraph.insertVertex(vertexX);

        myGraph.showAdjacencyMatrix();

        myGraph.insertEdge(0,1);
        myGraph.insertEdge(0,3);
        myGraph.insertEdge(0,4);
        myGraph.insertEdge(1,0);
        myGraph.insertEdge(1,2);
        myGraph.insertEdge(1,4);
        myGraph.insertEdge(2,1);
        myGraph.insertEdge(2,4);
        myGraph.insertEdge(2,5);
        myGraph.insertEdge(3,0);
        myGraph.insertEdge(3,4);
        myGraph.insertEdge(4,0);
        myGraph.insertEdge(4,1);
        myGraph.insertEdge(4,2);
        myGraph.insertEdge(4,3);
        myGraph.insertEdge(4,5);
        myGraph.insertEdge(5,2);
        myGraph.insertEdge(5,4);

        myGraph.showAdjacencyMatrix();
        myGraph.dfs(0);
        myGraph.bfs(0);
    }
}
