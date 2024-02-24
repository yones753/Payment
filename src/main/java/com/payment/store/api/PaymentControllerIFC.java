package com.payment.store.api;

import com.payment.store.bean.Order;
import com.payment.store.bean.Payment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/payment")
public interface PaymentControllerIFC {

    @Operation(
            summary = "Retrieve a Payment by Id",
            description = "Post a Payment object by specifying its id. The response is Payment object with id, title, description and published status.",
            tags = {"Payment", "post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Payment.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PostMapping("/pay")
    public ResponseEntity<?> pay(@RequestBody Order order);
}

