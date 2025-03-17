public class Client {
    private String fullName;
    private String accountNumber;
    private double balance;
    private ClientType clientType;
    private boolean welcomeBonusUsed;

    public Client(String fullName, String accountNumber, ClientType clientType) {
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.clientType = clientType;
        this.balance = 0;
        this.welcomeBonusUsed = false;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public boolean isWelcomeBonusUsed() {
        return welcomeBonusUsed;
    }

    public void setWelcomeBonusUsed(boolean welcomeBonusUsed) {
        this.welcomeBonusUsed = welcomeBonusUsed;
    }

    public double calculateCashback(double amount) {
        switch (clientType) {
            case BASIC:
                return amount >= 10000 ? amount * 0.01 : 0;
            case PREMIUM:
                return amount >= 10000 ? amount * 0.05 : 0;
            case VIP:
                if (amount >= 100000) return amount * 0.10;
                if (amount >= 10000) return amount * 0.05;
                return amount * 0.01;
            default:
                return 0;
        }
    }

    public double getMonthlyFee() {
        return clientType == ClientType.BASIC ? 100 : 0;
    }
} 