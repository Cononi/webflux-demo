package com.example.webfluxdemo.application.port.in;

import com.example.webfluxdemo.domain.TimesTable;

import java.util.List;

public interface TimesTableUseCase {

    TimesTable findSquare(int input);

    List<TimesTable> multiplicationTable(int input);
}
