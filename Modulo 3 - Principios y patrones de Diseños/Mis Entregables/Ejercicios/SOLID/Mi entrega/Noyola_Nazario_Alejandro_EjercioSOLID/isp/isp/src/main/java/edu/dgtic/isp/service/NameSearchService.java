package edu.dgtic.isp.service;

import java.util.List;

/**
 * Interfaz para servicios de búsqueda por nombre.
 *
 * @param <T> el tipo de entidad sobre la que se realiza la búsqueda.
 */
public interface NameSearchService<T> {
    /**
     * Encuentra entidades por su nombre.
     *
     * @param name el nombre a buscar.
     * @return una lista de entidades cuyo nombre coincide con el especificado.
     */
    List<T> findByName(String name);
}

