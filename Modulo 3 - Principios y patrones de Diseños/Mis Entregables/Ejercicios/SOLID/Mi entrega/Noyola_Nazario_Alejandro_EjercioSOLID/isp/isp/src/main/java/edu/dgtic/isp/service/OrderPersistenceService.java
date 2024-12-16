package edu.dgtic.isp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import edu.dgtic.isp.entity.Order;

/**
 * Servicio de persistencia en memoria para órdenes.
 */
public class OrderPersistenceService implements PersistenceService<Order>, NameSearchService<Order> {
    private static final Map<Long, Order> ORDERS = new HashMap<>();

    @Override
    public void save(Order entity) {
        synchronized (ORDERS) {
            ORDERS.put(entity.getId(), entity);
        }
    }

    @Override
    public void delete(Order entity) {
        synchronized (ORDERS) {
            ORDERS.remove(entity.getId());
        }
    }

    @Override
    public Order findById(Long id) {
        synchronized (ORDERS) {
            return ORDERS.get(id);
        }
    }

    @Override
    public List<Order> findByName(String name) {
        synchronized (ORDERS) {
            return ORDERS.values()
                    .stream()
                    .filter(order -> order.getCustomerName().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
        }
    }
}
