package business.service.Student;

import business.DAO.student.StudentDAO;
import business.DAO.student.StudentDAOImp;
import business.modal.Student;
import business.service.AppService;

import java.util.List;

public class studentServiceIpm implements StudentServices {
    private final StudentDAO studentDAO;
    public studentServiceIpm() {
        studentDAO = new StudentDAOImp();
    }
    @Override
    public List<Student> getAll() {
        return studentDAO.findAll();
    }

    @Override
    public boolean add(Student student) {
        return studentDAO.add(student);
    }

    @Override
    public boolean update(Student student) {
        return studentDAO.update(student);
    }

    @Override
    public boolean delete(Student student) {
        return studentDAO.delete(student);
    }

    @Override
    public int getCountStudentByStatus(boolean status) {
        return studentDAO.getCountStudentByStatus(status);
    }
}
