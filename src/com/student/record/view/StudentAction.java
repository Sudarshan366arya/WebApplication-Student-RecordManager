package com.student.record.view;
import java.util.List;
import com.student.record.controller.StudentManager;
import com.student.record.model.Student;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	
	private static final long serialVersionUID = 9149826260758390091L;
	private Student st;
    private List<Student> studentList;
    private int roll;
    
    private StudentManager stManager;
    
    public StudentAction() {
       stManager = new StudentManager();
    }
    public String execute() {
        this.studentList = stManager.list();
        System.out.println("execute called");
        return SUCCESS;
    }
    public String add() {
        System.out.println(getStudent());
        try {
        	if(getStudent().getRoll()==0){
        		 stManager.add(getStudent());
        	}else{
        		 stManager.adddone(getStudent());
        	}
            } catch (Exception e) {
            e.printStackTrace();
        }
        this.studentList = stManager.list();
        return SUCCESS;
    }
    public String view() {
        System.out.println(getStudent());
       
        this.studentList = stManager.list();
        return SUCCESS;
    }
    
    public String search() {
        System.out.println("-----------------Check----------->>>>>>>>>>>>>>>>>>"+getStudent().getName());
     Student cont=new Student();
     cont=getStudent();
       this.studentList = stManager.search(cont.getName(),cont.getBatch(),cont.getContact_No());
       return SUCCESS;
    }
    public String delete() {
        stManager.delete(getRoll());
        return SUCCESS;
    }
    public String update() {
    	 stManager.update(getRoll());
        return SUCCESS;
        }
    public String adddone() {
   	stManager.adddone(getStudent());

       return SUCCESS;
       }

    public Student getStudent() {
        return st;
    }
    public List<Student> getStudentList() {
        return studentList;
        }
    public void setStudent(Student student) {
        this.st = student;
    }
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getRoll() {
        return roll;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }
    public Student getStudentit(){
        return stManager.update(getRoll());   
        }
 
 

}
