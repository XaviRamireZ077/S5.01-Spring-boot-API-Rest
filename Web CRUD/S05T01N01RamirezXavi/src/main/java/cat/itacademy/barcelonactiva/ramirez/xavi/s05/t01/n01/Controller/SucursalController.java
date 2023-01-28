package cat.itacademy.barcelonactiva.ramirez.xavi.s05.t01.n01.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cat.itacademy.barcelonactiva.ramirez.xavi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.ramirez.xavi.s05.t01.n01.model.services.SucursalService;

@Controller
public class SucursalController {

        @Autowired
        private SucursalService sucursalService;

        // display list of employees
        @GetMapping("/")
        public String viewHomePage(Model model) {
            model.addAttribute("listSucursales", sucursalService.getAllSucursales());
            return "index";
        }

        @GetMapping("/showNewEmployeeForm")
        public String showNewEmployeeForm(Model model) {
            // create model attribute to bind form data
            Sucursal sucursal = new Sucursal();
            model.addAttribute("employee", sucursal);
            return "new_sucursal";
        }

        @PostMapping("/saveEmployee")
        public String saveEmployee(@ModelAttribute("sucursal") Sucursal sucursal) {
            // save employee to database
            sucursalService.saveSucursal(sucursal);
            return "redirect:/";
        }

        @GetMapping("/showFormForUpdate/{id}")
        public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

            // get employee from the service
            Sucursal sucursal = sucursalService.getSucursalById(id);

            // set employee as a model attribute to pre-populate the form
            model.addAttribute("sucursal", sucursal);
            return "update_sucursal";
        }

        @GetMapping("/deleteEmployee/{id}")
        public String deleteEmployee(@PathVariable(value = "id") long id) {

            // call delete employee method
            this.sucursalService.deleteSucursalById(id);
            return "redirect:/";
        }





}
