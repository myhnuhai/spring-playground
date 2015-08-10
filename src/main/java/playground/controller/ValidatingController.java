package playground.controller;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;

@RestController
public class ValidatingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatingController.class);

    public static final class ValidatingForm implements Serializable {

        @NotEmpty
        @Length(min = 2, max = 20)
        private String name;

        @DecimalMin("18")
        @DecimalMax("100")
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @RequestMapping("/validating")
    public String validating(
        @Valid ValidatingForm form, BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            LOGGER.debug(bindingResult.getFieldError("name").toString());
            LOGGER.debug(bindingResult.getFieldError("age").toString());
            return "NG";
        }

        return "OK";
    }
}
