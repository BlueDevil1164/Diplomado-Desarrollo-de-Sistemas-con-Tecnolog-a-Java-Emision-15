package edu.dgtic.ocp;

import java.util.List;

public class ISPSubscriber extends Subscriber {
    private long freeUsage;

    // Constructor vacío
    public ISPSubscriber() {
        super();
    }

    // Implementación del método calculateBill específico para ISPSubscriber
    @Override
    public double calculateBill() {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(getSubscriberId());
        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalData - freeUsage;
        return chargeableData * getBaseRate() / 100.0;
    }

    // Getter y Setter para freeUsage
    public long getFreeUsage() {
        return freeUsage;
    }

    public void setFreeUsage(long freeUsage) {
        this.freeUsage = freeUsage;
    }
}


