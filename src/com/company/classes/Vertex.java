package com.company.classes;

import java.util.Objects;

public class Vertex {
    public boolean isVisited;
    private String name;
    public Vertex(String  name){
        this.name = name;
        isVisited = false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "isVisited=" + isVisited +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return isVisited == vertex.isVisited &&
                Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isVisited, name);
    }
}
