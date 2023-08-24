package com.arantes.hexagonal.config;

import com.arantes.hexagonal.adapters.out.FindAddressByZipcodeAdapter;
import com.arantes.hexagonal.adapters.out.InsertCustomerAdapter;
import com.arantes.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.arantes.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    // Não injetar as portas e sim os adapters que sao as implementações delas
    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipcodeAdapter findAddressByZipcodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ){
        return new InsertCustomerUseCase(insertCustomerAdapter,findAddressByZipcodeAdapter, sendCpfValidationAdapter);
    }

}
