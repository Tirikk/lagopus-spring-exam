package com.greenfox.exam.spring.model;

import java.util.ArrayList;

public class ProjectList {
  ArrayList<Project> projectList;

  public ProjectList() {
  }

  public ProjectList(ArrayList<Project> projectList) {
    this.projectList = projectList;
  }

  public ArrayList<Project> getProjectList() {
    return projectList;
  }

  public void setProjectList(ArrayList<Project> projectList) {
    this.projectList = projectList;
  }
}
