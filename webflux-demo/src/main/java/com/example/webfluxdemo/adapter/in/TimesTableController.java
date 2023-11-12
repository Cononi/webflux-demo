package com.example.webfluxdemo.adapter.in;

import com.example.webfluxdemo.application.port.in.TimesTableUseCase;
import com.example.webfluxdemo.domain.TimesTable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("math")
@RequiredArgsConstructor
public class TimesTableController {

    private TimesTableUseCase timesTableUseCase;

    @GetMapping("square/{input}")
    public TimesTable findSquare(@PathVariable int input){
        return this.timesTableUseCase.findSquare(input);
    }

    @GetMapping("table/{input}")
    public List<TimesTable> multipicationTable(@PathVariable int input){
        return this.timesTableUseCase.multiplicationTable(input);
    }
}
