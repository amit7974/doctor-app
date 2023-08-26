package org.mvc.controller;
import java.util.List;
import org.mvc.dao.DoctorDAO;
import org.mvc.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class DoctorController {
  @Autowired
  private DoctorDAO dao;
  @RequestMapping(value = {"/","/index"})
  public String home(Model model) {
    List<Doctor> list = dao.getListOfDoctors();
    model.addAttribute("list", list);
    return "index";
  }
  
  @RequestMapping("/doctorform")
  public String showForm(Model model) {
    model.addAttribute("doctor", new Doctor());
    return "add_doctor";  //WEB-INF/views/add-doctor.jsp
  }
  /*
   * This method will save an doctor object into table.
   */
  @RequestMapping(value = "/add" , method = RequestMethod.POST)
  public String addDoctor(@ModelAttribute("doctor") Doctor d) {
    dao.insert(d);
    return "redirect:/index";  //WEB-INF/views/add-doctor.jsp
  }
  /*
   * This method will show the Edit Doctor Page to user
   */
  @RequestMapping(value = "editdoctorform/{id}")
  public String showEditForm(@PathVariable("id") Integer id, Model model) {
    Doctor doctor = dao.getDoctorById(id);
    model.addAttribute("doctor", doctor);
    return "update_doctor";  //WEB-INF/views/update-doctor.jsp
  }
  /*
   * This method will update doctor's information
   */
  @RequestMapping(value = "/update" , method = RequestMethod.POST)
  public String updateDoctor(@ModelAttribute("doctor") Doctor d) {
    dao.update(d);
    return "redirect:/index";  //WEB-INF/views/index.jsp
  }
  @RequestMapping(value = "deletedoctor/{id}")
  public String deleteDoctor(@PathVariable("id") Integer id, Model model) {
    dao.delete(id);
    return "redirect:/index";  //WEB-INF/views/index.jsp
  }
  
}