package au.com.aon.domain.api;

import au.com.aon.domain.service.Customer;
import au.com.aon.domain.service.InsuranceService;
import au.com.aon.domain.service.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/api/v1")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(path = "/customer/quotes", method = RequestMethod.POST)
    public ResponseEntity<List<Quote>> greeting(@Valid @RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.OK).body(insuranceService.getQuotes(customer));
    }
}
