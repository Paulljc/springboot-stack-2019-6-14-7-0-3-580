package com.tw.apistackbase;

import com.tw.apistackbase.Service.EmployeeService;
import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmpolyeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.anyString;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmpolyeeRepository empolyeeRepository;

    @Test
    public void should_return_employee_infomation() throws Exception {
        Employee employee = new Employee();
        employee.setName("haha");
        employee.setAge(41);
        employee.setGender("Male");
        employee.setId("2222");

        when(empolyeeRepository.findById(anyString())).thenReturn(employee);

        ResultActions result = mvc.perform(get("/employees/{employeeId}", employee.getId()));
        ;

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("haha")))
                .andExpect(jsonPath("$.age", is(41)))
                .andExpect(jsonPath("$.gender", is("Male")))
                .andExpect(jsonPath("$.id", is("2222")));
    }
}
