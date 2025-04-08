package business.DAO.student;

import business.DAO.AppDAO;
import business.modal.Student;

public interface StudentDAO extends AppDAO<Student> {
    int getCountStudentByStatus(boolean status);
}
