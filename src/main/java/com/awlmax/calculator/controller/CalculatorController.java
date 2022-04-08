package com.awlmax.calculator.controller;

import com.awlmax.calculator.model.OperationModel;
import com.awlmax.calculator.service.CalculateSimple;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Tag(name = "OperationModel")
public class CalculatorController {
    OperationModel operationModel = new OperationModel();

    @Autowired
    private CalculateSimple calculateSimple;

    @RequestMapping("/calculator")
    public String getCalculatorPage(Model model){
        model.addAttribute("operationModel",operationModel);
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="add", method = RequestMethod.POST)
    @Operation(summary = "Получить данные", responses = {
            @ApiResponse(description = "Успех", responseCode = "200",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = OperationModel.class))),
            @ApiResponse(description = "Неудача",responseCode = "409",content = @Content)
    })
    public String add(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.add(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="subtract", method = RequestMethod.POST)
    @Operation(summary = "Получить данные", responses = {
            @ApiResponse(description = "Успех", responseCode = "200",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = OperationModel.class))),
            @ApiResponse(description = "Неудача",responseCode = "409",content = @Content)
    })
    public String subtract(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.subtract(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="multiply", method = RequestMethod.POST)
    @Operation(summary = "Получить данные", responses = {
            @ApiResponse(description = "Успех", responseCode = "200",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = OperationModel.class))),
            @ApiResponse(description = "Неудача",responseCode = "409",content = @Content)
    })
    public String multiply(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.multiply(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="divide", method = RequestMethod.POST)
    @Operation(summary = "Получить данные", responses = {
            @ApiResponse(description = "Успех", responseCode = "200",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = OperationModel.class))),
            @ApiResponse(description = "Неудача",responseCode = "409",content = @Content)
    })
    public String divide(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("result", calculateSimple.divide(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculator", params="clearSimple", method = RequestMethod.POST)
    @Operation(summary = "Получить данные", responses = {
            @ApiResponse(description = "Успех", responseCode = "200",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = OperationModel.class))),
            @ApiResponse(description = "Неудача",responseCode = "409",content = @Content)
    })
    public String clearSimple(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("operationModel",  calculateSimple.clearSimple(operationModel));
        model.addAttribute("result", 0);
        return "calculator";
    }
}
