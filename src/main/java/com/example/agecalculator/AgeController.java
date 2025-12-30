package com.example.agecalculator;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.Period;

@RestController
public class AgeController {

    @GetMapping("/calculate")
    public String calculateAge(@RequestParam String dob) {

        LocalDate birthDate = LocalDate.parse(dob);
        LocalDate today = LocalDate.now();

        if (birthDate.isAfter(today)) {
            return "Invalid Date of Birth";
        }

        Period age = Period.between(birthDate, today);

        return "Age: " + age.getYears() + " Years "
                       + age.getMonths() + " Months "
                       + age.getDays() + " Days";
    }
}
