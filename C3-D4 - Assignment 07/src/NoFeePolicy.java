// Chính sách C: Miễn phí hoàn toàn
public class NoFeePolicy implements LateFeePolicy {
    @Override
    public double applyPolicy(double baseFee) { return 0.0; }
    @Override
    public String getPolicyName() { return "No Fee Policy"; }
}
