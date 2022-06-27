package com.codeninja.asps.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankDetails {
    private String BankName;
    private String AccountNumber;
    private String BranchName;
    private String IFSC;

}
