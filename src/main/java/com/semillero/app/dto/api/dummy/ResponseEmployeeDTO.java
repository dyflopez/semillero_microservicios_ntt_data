package com.semillero.app.dto.api.dummy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseEmployeeDTO {

    private Long id;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("employee_salary")
    private  Long employeeSalary;

    @JsonProperty("employee_age")
    private  Long employeeAge;

    @JsonProperty("profile_image")
    private  String  profileImage;

}
