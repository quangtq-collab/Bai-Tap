// Chính sách B: Giảm 50% phí phạt
public class DiscountFeePolicy implements LateFeePolicy {
    @Override
    public double applyPolicy(double baseFee) { return baseFee * 0.5; }
    @Override
    public String getPolicyName() { return "Discount Fee Policy"; }
}
