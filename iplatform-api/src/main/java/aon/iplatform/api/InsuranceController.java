package aon.iplatform.api;

import aon.iplatform.domain.model.common.Customer;
import aon.iplatform.domain.model.common.Quote;
import aon.iplatform.service.business.InsuranceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "Insurance API", description = "Exposes APIs for insurance platform")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @ApiOperation(value = "Gets quotes", response = Quote.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Quote.class, responseContainer = "List")
    })
    @RequestMapping(path = "/customer/quotes", method = RequestMethod.POST)
    public ResponseEntity<List<Quote>> greeting(@Valid @RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.OK).body(insuranceService.getQuotes(customer));
    }
}
