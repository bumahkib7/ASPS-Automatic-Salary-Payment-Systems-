package com.codeninja.asps.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class BankDetails {
    private String BankName;
    private String AccountNumber;
    private String BranchName;
    private String IFSC;

}
