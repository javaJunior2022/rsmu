package ru.Exceptions;

public class CourseAlreadyExistException  extends RuntimeException {
    public CourseAlreadyExistException(String message) {
        super("This course exists "+message);
    }
}
