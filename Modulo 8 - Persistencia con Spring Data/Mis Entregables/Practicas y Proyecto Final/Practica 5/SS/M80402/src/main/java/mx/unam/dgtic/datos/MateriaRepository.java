package mx.unam.dgtic.datos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface MateriaRepository extends CrudRepository<Materia, String> {

    // Métodos de Búsqueda con Consultas Derivadas
    List<Materia> findByMateria(String materia);

    List<Materia> getByMateria(String materia);

    List<Materia> searchByMateria(String materia);

    List<Materia> readByMateria(String materia);

    List<Materia> queryByMateria(String materia);

    Stream<Materia> streamByMateria(String materia);

    //------------------------------------------------------------


    List<Materia> readByCreditos(Integer creditos);

    List<Materia> readByHoras(Integer horas);

    List<Materia> findByMateriaNot(String materia);

    Stream<Materia> streamByMateriaNot(String materia);

    // Métodos de Conteo
    Long countByMateria(String materia);

    Long countByMateriaNot(String materia);

    // Nulos
    List<Materia> findByCreditosIsNull();

    List<Materia> findByCreditosIsNotNull();

    Long countByCreditosIsNull();

    Long countByCreditosIsNotNull();

    //------------------------------------------------------------


    // Operadores Lógicos
    List<Materia> queryByMateriaAndCreditos(String materia, Integer creditos);

    List<Materia> queryByMateriaOrCreditos(String materia, Integer creditos);

    List<Materia> queryByMateriaOrCreditosNull(String materia);

    List<Materia> queryByMateriaOrCreditosNotNull(String materia);

    List<Materia> queryByMateriaOrCreditosAndHoras(String materia, Integer creditos, Integer horas);

    Long countByMateriaOrCreditos(String materia, Integer creditos);

    Boolean existsByMateriaOrCreditos(String materia, Integer creditos);

    // Limitar Consultas
    List<Materia> readFirstByHoras(Integer horas);

    List<Materia> readFirstBymateria(String materia);

    List<Materia> readTopByHoras(Integer horas);

    List<Materia> readTop1ByHoras(Integer horas);

    List<Materia> readTop3ByHoras(Integer horas);

    // Orderna Consultas
   // List<Materia> readTop3ByHorasOrderByMateriaDesc(Integer horas);

    List<Materia> findByMateriaOrderByCreditosAsc(String materia);

    List<Materia> findByMateriaOrderByCreditosDesc(String materia);

    List<Materia> readTop2ByMateriaOrderByCreditosAsc(String materia);

    List<Materia> readTop2ByMateriaOrderByCreditosDesc(String materia);

    // Operadores
    // In
    List<Materia> searchByHorasIn(Collection<Integer> horas);

    List<Materia> searchByHorasNotIn(Collection<Integer> horas);

    List<Materia> searchByMateriaIn(Collection<String> materias);

    List<Materia> searchByMateriaNotIn(Collection<String> materias);

    // Between
    List<Materia> searchByHorasBetweenOrderByHoras(Integer horasIni, Integer horasFin);

    List<Materia> searchByMateriaBetweenOrderByMateria(String materiaIni, String materiaFin);

    // Before, After
    List<Materia> queryByCreditosBefore(Integer creditos);

    List<Materia> queryByCreditosAfter(Integer creditos);

    // Mayor que, Menor que
    List<Materia> queryByHorasLessThan(Integer estatura);

    List<Materia> queryByHorasLessThanEqual(Integer estatura);

    List<Materia> queryByHorasGreaterThan(Integer estatura);

    List<Materia> queryByHorasGreaterThanEqual(Integer estatura);

    // Patrones
    List<Materia> findByMateriaStartingWith(String inicia);

    List<Materia> findByMateriaContaining(String contiene);

    List<Materia> findByMateriaEndingWith(String termina);

    // Like
    List<Materia> findByMateriaLike(String materia);

    List<Materia> findByMateriaNotLike(String materia);

    Long countByMateriaLike(String materia);

    Long countByMateriaNotLike(String materia);

    // Eliminar
    @Transactional
    List<Materia> deleteByMateriaLike(String patron);



}
