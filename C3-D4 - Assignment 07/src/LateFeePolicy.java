// LateFeePolicy.java — Interface Strategy cho chính sách tính phí phạt
public interface LateFeePolicy {
    double applyPolicy(double baseFee);
    String getPolicyName();
}
