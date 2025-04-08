package business.service.Student;

import business.modal.Student;
import business.service.AppService;

public interface StudentServices extends AppService<Student> {
    int getCountStudentByStatus(boolean status);
}
