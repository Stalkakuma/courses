package lt.vidunas.courses.exceptions;


public class CourseNotFoundException  extends RuntimeException{
    public CourseNotFoundException(String message)
    {
        super(message);
    }

}
