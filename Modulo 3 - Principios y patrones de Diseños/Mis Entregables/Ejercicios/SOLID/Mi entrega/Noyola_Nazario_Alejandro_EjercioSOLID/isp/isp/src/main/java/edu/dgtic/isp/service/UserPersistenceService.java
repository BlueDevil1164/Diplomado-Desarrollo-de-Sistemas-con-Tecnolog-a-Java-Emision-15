package edu.dgtic.isp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import edu.dgtic.isp.entity.User;

/**
 * Servicio de persistencia en memoria para usuarios.
 */
public class UserPersistenceService implements PersistenceService<User>, NameSearchService<User> {
	private static final Map<Long, User> USERS = new HashMap<>();

	@Override
	public void save(User entity) {
		synchronized (USERS) {
			USERS.put(entity.getId(), entity);
		}
	}

	@Override
	public void delete(User entity) {
		synchronized (USERS) {
			USERS.remove(entity.getId());
		}
	}

	@Override
	public User findById(Long id) {
		synchronized (USERS) {
			return USERS.get(id);
		}
	}

	@Override
	public List<User> findByName(String name) {
		synchronized (USERS) {
			return USERS.values()
					.stream()
					.filter(user -> user.getName().equalsIgnoreCase(name))
					.collect(Collectors.toList());
		}
	}
}

