package entity;

public enum SQLLinkSymbol {
    AND("and"),//and 连接符
    OR("or"),// or 连接符
    EMPTY("");//第一个条件，无链接符


    private String linkSymbol;

    SQLLinkSymbol(String linkSymbol) {
        this.linkSymbol = linkSymbol;
    }

    public String getLinkSymbol() {
        return linkSymbol;
    }
}
