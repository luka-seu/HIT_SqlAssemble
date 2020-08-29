package entity;

public enum SQLFields {
    CUSTOMERID("customerId"),
    COMPANYNAME("companyName"),
    CONTACTNAME("contactName"),
    CONTACTTITLE("contactTitle"),
    REGION("region"),
    POSTALCODE("postalCode"),
    COUNTRY("country"),
    ;

    private String field;

    SQLFields(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
