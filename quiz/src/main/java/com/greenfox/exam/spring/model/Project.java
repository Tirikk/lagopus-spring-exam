package com.greenfox.exam.spring.model;

public class Project {
  int id;
  String nameOfProject;

  public Project() {
  }

  public Project(int id, String nameOfProject) {
    this.id = id;
    this.nameOfProject = nameOfProject;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNameOfProject() {
    return nameOfProject;
  }

  public void setNameOfProject(String nameOfProject) {
    this.nameOfProject = nameOfProject;
  }
}
