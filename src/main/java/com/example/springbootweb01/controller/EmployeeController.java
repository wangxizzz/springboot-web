package com.example.springbootweb01.controller;

import com.example.springbootweb01.dao.DepartmentDao;
import com.example.springbootweb01.dao.EmployeeDao;
import com.example.springbootweb01.entities.Department;
import com.example.springbootweb01.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){    // 当然也可以用map来保存数据带入页面
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        // 模板引擎默认从类路径下拼接
        return "/emp/list";
    }

    // 做页面跳转
    @GetMapping("/emp")
    public String toAddPage(Model model){
        // 查看所有部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "/emp/add";
    }

    /**
     * 增加一个员工实体
     * @param employee 员工实体
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(@RequestBody Employee employee){
        System.out.println("===============================================================");
        System.out.println(employee);
        // 重定向到服务器地址/emps.不让模板引擎拼接。
        return "redirect:/emps";
    }

    /**
     * 根据id查询员工实体
     * @param id 员工id
     * @param model 把数据带入到html页面进行解析。
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        // 重用该页面
        return "/emp/add";
    }

    @PutMapping("emp/{id}")
    public String update(@PathVariable("id") Integer id, @RequestBody Employee employee) {

        return "redirect:/emps";
    }
}
