package business.service.Student;

import business.model.Student;
import business.service.AppService;

public interface StudentServices extends AppService<Student> {
    int getCountStudentByStatus(boolean status);
}
