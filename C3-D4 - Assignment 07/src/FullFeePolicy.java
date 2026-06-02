// Chính sách A: Tính phí đầy đủ
public class FullFeePolicy implements LateFeePolicy {
    @Override
    public double applyPolicy(double baseFee) { return baseFee; }
    @Override
    public String getPolicyName() { return "Full Fee Policy"; }
}
