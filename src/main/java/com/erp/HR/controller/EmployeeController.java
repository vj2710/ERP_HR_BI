package com.erp.HR.controller;

import com.erp.HR.domain.EmployeeInfo;
import com.erp.HR.service.EmployeeService;
import com.erp.HR.service.HiringService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/HR/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    HiringService hiringService;

    @GetMapping("/search")
    public List<EmployeeInfo> getEmployeeInfo(@RequestParam(value = "id", required = false) int employeeId,
                                              @RequestParam(value = "dept", required = false) String department,
                                              @RequestParam(value = "jobTitle", required = false) String jobTitle){

        if(department==null && jobTitle==null){
            if(employeeId>0){
                return employeeService.getAllByEmployeeId(employeeId);
            } else {
                return null;
            }
        } else {
            if(employeeId<0){
                return employeeService.getAllByDepartmentAndJobTitle(department, jobTitle);
            } else {
                return employeeService.getAllByEmployeeIdAndDepartmentAndJobTitle(employeeId, department, jobTitle);
            }
        }
    }

    @PostMapping("/newEmployee")
    public String insertJoineeDetails(@RequestBody Object insertNewJoinee){

        Gson gson = new Gson();
        String jsonToString = gson.toJson(insertNewJoinee);

        Map<String, Object> map = gson.fromJson(jsonToString, new TypeToken<Map<String, Object>>(){}.getType());
        int empID = employeeService.addNewJoinee((char) map.get("gender"),
                (String) map.get("dept"), (String) map.get("jobTitle"),
                (int) map.get("manager"), (char) map.get("active"));

        boolean updateHiring = hiringService.addNewJoinee(empID, (char) map.get("emplType"));

        if(updateHiring)
            return "Successfully added new hires";
        else
            return "Falied to add new hires";
    }

    @PutMapping("/increment/{employeeId}")
    public String updateSalaryIncrement(@PathVariable int employeeId){
        if(employeeId < 0){
            return "Incorrect employee Id";
        }
        if(employeeService.updateSalaryIncrement(employeeId))
            return "Successfully calculated and updated salary of employee";
        else
            return "Failed to calculate and update salary of employee.";
    }


}