package sit.int204.classicmodelsservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.Model.Count;
import sit.int204.classicmodelsservice.Model.Employee;
import sit.int204.classicmodelsservice.Model.Office;
import sit.int204.classicmodelsservice.Service.OfficeService;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService service;
    @GetMapping("")
    public List<Office> getAllOffices(@RequestParam(required = false) String[] param) {
        return service.getAllOffice(param);

    }
    @GetMapping("/{officeCode}/employees")
    public Set<Employee> getOfficeEmployee(@PathVariable String officeCode){
        return service.getOffice(officeCode).getEmployees();
    }
    @GetMapping("/{officeCode}")
    public Office getOfficeById(@PathVariable String officeCode) {
        return service.getOffice(officeCode);
    }
    @PostMapping("")
    public Office addNewOffice(@RequestBody Office office) {
        return service.createNewOffice(office);
    }
    @PutMapping("/{officeCode}")
    public Office updateOffice(@RequestBody Office office, @PathVariable String officeCode) {
        return service.updateOffice(officeCode, office);
    }
    @DeleteMapping("/{officeCode}")
    public void removeOffice(@PathVariable String officeCode) {
        service.removeOffice(officeCode);
    }

    @GetMapping("/count")
    public Count getOfficesCount() {
        return service.getOfficeCount();
    }
}
