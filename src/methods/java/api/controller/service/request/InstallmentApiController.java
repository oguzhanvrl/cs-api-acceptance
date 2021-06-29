package api.controller.service.request;

import api.controller.service.GeneralApiController;
import api.controller.service.ReadableResponse;

import static api.controller.utility.constant.Config.getApiUrl;


public class InstallmentApiController extends GeneralApiController {

    public InstallmentApiController() {
        super(getApiUrl());
    }

    public ReadableResponse getHealthCheck() {
        return getRequest("/health-check");
    }

    public ReadableResponse getInstallment() {
        return getRequest("/test/installment=");
    }

    public ReadableResponse getInstallment(int installmentCount) {
        return getRequest("/test/installment=" + installmentCount);
    }

}
