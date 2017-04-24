package com.example.cmltdstudent.inclassassignment11_ningelb;

import java.io.Serializable;

/**
 * Created by cmltdstudent on 4/17/17.
 */

public class Monument implements Serializable {

    public String id;
    public String name;
    public int built;
    public boolean visited;

    public Monument(){


    }

    public Monument(String id, String name, int built, boolean visited) {
        this.id = id;
        this.name = name;
        this.built = built;
        this.visited = visited;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuilt() {
        return built;
    }

    public void setBuilt(int built) {
        this.built = built;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Monument " + "\n" +
                "id: " + id + "\n" +
                "name: " + name + "\n"  +
                "built: " + built + "\n" +
        "visited: " + visited;
    }
}
