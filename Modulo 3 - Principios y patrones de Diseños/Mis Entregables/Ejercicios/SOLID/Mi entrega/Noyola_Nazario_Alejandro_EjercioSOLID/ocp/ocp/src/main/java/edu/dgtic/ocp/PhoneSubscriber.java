package edu.dgtic.ocp;

import java.util.List;

public class PhoneSubscriber extends Subscriber {
    // Constructor vacío
    public PhoneSubscriber() {
        super();
    }

    // Implementación del método calculateBill específico para PhoneSubscriber
    @Override
    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(getSubscriberId());
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return totalDuration * getBaseRate() / 100.0;
    }
}
