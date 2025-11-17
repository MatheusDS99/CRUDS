package Services;

import Entities.*;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(){

    }

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService=onlinePaymentService;
    }

    public void processContract(Contracts contracts, int months){
        double basicQuota = contracts.getTotalValue()/months;

        for (int i = 1; i<=months;i++){
            LocalDate dueDate = contracts.getDate().plusMonths(i);
            double interest = onlinePaymentService.interest(basicQuota, i);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota+interest+fee;
            contracts.getInstallments().add(new Installment(dueDate, quota));

        }

    }



}
