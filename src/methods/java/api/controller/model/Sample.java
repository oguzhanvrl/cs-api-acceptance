package api.controller.model;

public enum Sample {
    EMPTY_INSTALLMENT_COUNT("installment/get-empty-installment.json"),
    INSTALLMENT_COUNT_0("installment/get-installment-0.json"),
    INSTALLMENT_COUNT_1("installment/get-installment-1.json");

    private final String path;

    Sample(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
