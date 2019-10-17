package com.company.classes;

import java.util.*;

public class Graph {
    private List<Vertex> vertexArrayList;
    private int numberOfVertices;
    private int adjacencyMatrix[][];

    public Graph(int numberOfV) {
        this.numberOfVertices = numberOfV;
        vertexArrayList = new ArrayList<>(numberOfVertices);
        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
        for (int i = 0; i < adjacencyMatrix.length; i++)
            for (int j = 0; j < adjacencyMatrix.length; j++)
                adjacencyMatrix[i][j] = 0;
    }

    public void insertVertex(Vertex vertex) {
        if (vertexArrayList.size() != numberOfVertices)
            vertexArrayList.add(vertex);
        else System.out.println("vertexArray is full");
    }

    public void insertEdge(int begin, int end) {
        adjacencyMatrix[begin][end] = 1;
        adjacencyMatrix[end][begin] = 1;
    }

    public int getUnvisitedV(int vertexFromList){
        for (int i = 0; i < adjacencyMatrix.length ; i++) {
            if (adjacencyMatrix[vertexFromList][i] == 1 && vertexArrayList.get(i).isVisited == false)
                return i;
        }
        return -1;
    }

    public int convertVertex(Vertex currentVertex){
        for (int i = 0; i <vertexArrayList.size() ; i++) {
            if (currentVertex.getName() == vertexArrayList.get(i).getName())
                return i;
        }
        return 0;
    }
    public void bfs(int certainIndexOfVertex){
        System.out.println("\nbfs started :" + vertexArrayList.get(certainIndexOfVertex).getName());
        vertexArrayList.get(certainIndexOfVertex).isVisited = true;
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertexArrayList.get(certainIndexOfVertex));
        int insertingVertex;

        while (!queue.isEmpty()){
            Vertex currentVertex = queue.poll();
            while ((insertingVertex = getUnvisitedV(convertVertex(currentVertex))) != -1){
                queue.add(vertexArrayList.get(insertingVertex));
                vertexArrayList.get(insertingVertex).isVisited = true;
                System.out.println(vertexArrayList.get(insertingVertex).getName() + " -> ");
            }
        }
        System.out.println("end");


    }
    public void showAdjacencyMatrix() {
        System.out.printf("%n ");
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.printf("%3s", vertexArrayList.get(i).getName());
        }
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.printf("%n%s", vertexArrayList.get(i).getName());
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.printf("%3d", adjacencyMatrix[i][j]);
            }
        }
        System.out.printf("%n ");
    }




    public void dfs(int certainIndexOfVertex){
        System.out.println("\ndsf started :" + vertexArrayList.get(certainIndexOfVertex).getName());
        Stack<Vertex> stack = new Stack<>();
        stack.push(vertexArrayList.get(certainIndexOfVertex));
        vertexArrayList.get(certainIndexOfVertex).isVisited = true;

        while (!stack.isEmpty()){
//            int adjacencyVertex = getVisitedVertices( stack.indexOf(stack.peek()));
            int adjacencyVertex = getUnvisitedVertices(vertexArrayList.indexOf(stack.peek()));
            if(adjacencyVertex == -1)
                stack.pop();
            else {
                vertexArrayList.get(adjacencyVertex).isVisited = true;
                stack.push(vertexArrayList.get(adjacencyVertex));
                System.out.println(vertexArrayList.get(adjacencyVertex).getName() + " -> ");
            }
        }
        for (int i = 0; i <vertexArrayList.size() ; i++) {
            vertexArrayList.get(i).isVisited = false;
        }
        System.out.println("end");
    }

    public int getUnvisitedVertices(int vertexFromStack){
        for (int i = 0; i < adjacencyMatrix.length ; i++) {
            if (adjacencyMatrix[vertexFromStack][i] == 1 && vertexArrayList.get(i).isVisited == false)
                return i;
        }
        return -1;
    }


}

