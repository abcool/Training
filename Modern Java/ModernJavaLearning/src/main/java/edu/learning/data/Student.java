package edu.learning.data;

import java.util.List;

public record Student(String name, int gradelevel, double gpa, String gender, List<String> activities) {
}
