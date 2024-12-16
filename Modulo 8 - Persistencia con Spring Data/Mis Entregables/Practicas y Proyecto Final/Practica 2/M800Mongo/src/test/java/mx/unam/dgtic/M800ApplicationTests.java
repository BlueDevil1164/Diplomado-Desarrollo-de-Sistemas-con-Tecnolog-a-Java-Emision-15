package mx.unam.dgtic;


import mx.unam.dgtic.datos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class M800ApplicationTests {
	final  String ALUMNO ="ALEJANDRO NOYOLA NAZARIO";
	final String ID = "19982106";
	final String MATRICULA ="MT1";
	final String CLAVE_MATERIA ="MAT101";

	@Autowired
	AlumnoRepository repositorioAlumno;

	@Autowired
	MateriaRepository repositorioMateria;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	void buscarTodosTest() {
		System.out.println(ALUMNO);
		System.out.println("BUSCAR ALUMNOS CON MONGODB");
		repositorioAlumno.findAll().forEach(System.out::println);
	}

	@Test
	void ActualizarUnoTest() {
		System.out.println(ALUMNO);
		System.out.println("Actualizar Alumno por ID");

		Optional<Alumno> optional = repositorioAlumno.findById(ID);
		if (optional.isPresent()){
			Alumno a = optional.get();
			System.out.println("Nombre: " + a.getNombre() );
			System.out.println("Paterno: " + a.getPaterno() );
			System.out.println("Años: " + a.getEdad().getAnios() );
			System.out.println("Evaluaciones: " );
			a.getEvaluaciones().forEach(e -> System.out.println(e.getMateria() + " "+ e.getCalificacion() + " " +e.getFecha())

			);

		}
	}


	@Test
	void EditarUnoTest() {
		System.out.println(ALUMNO);
		System.out.println("Editar Alumno por ID");

		Optional<Alumno> optional = repositorioAlumno.findById(ID);
		if (optional.isPresent()){
			Alumno a = optional.get();

			System.out.println("Alumno antes de la edicion");
			System.out.println(a);

			a.setNombre("Ale");
			a.setPaterno("Noyo");

			List<Evaluacion> evaluacions = a.getEvaluaciones();
			evaluacions.add(new Evaluacion("JDBC", 9.0, new Date()));

			a.setEvaluaciones(evaluacions);
			a.setEdad(new Edad(26, 23, 77));
			repositorioAlumno.save(a);

			System.out.println("DATOS DESPUES DE LA EDICION");
			a = repositorioAlumno.findById(ID).get();

			System.out.println("Nombre: " + a.getNombre() );
			System.out.println("Paterno: " + a.getPaterno() );
			System.out.println("Años: " + a.getEdad().getAnios() );
			System.out.println("Evaluaciones: " );
			a.getEvaluaciones().forEach(e -> System.out.println(e.getMateria() + " "+ e.getCalificacion() + " " +e.getFecha())

			);

		}
	}



	@Test
	void  mongoTemplateTest(){
		System.out.println(ALUMNO);
		System.out.println("Mongo Template");

		Alumno alumno = new Alumno(MATRICULA, "ALEJANDRO", "NOYOLA", new Date(), 1.78);

		mongoTemplate.insert(alumno);

		System.out.println("Total de alumnos en MongoDB " + repositorioAlumno.count());
		repositorioAlumno.findAll().forEach(System.out::println);
	}

	@Test
	void buscarMongoTemplateTest(){
		System.out.println(ALUMNO);
		System.out.println("Buscar con MongoTemplate criteria");

		Query query = new Query();
		query.addCriteria(Criteria.where("matricula").is("MT1"));
		System.out.println("Alumnos con matricula MT1");
		mongoTemplate.find(query, Alumno.class).forEach(System.out::println);

		query = new Query();
		query.addCriteria(Criteria.where("estatura").gt(1.75));
		System.out.println("Alumnos con estatura mayor a 1.75");
		mongoTemplate.find(query, Alumno.class).forEach(System.out::println);

		query = new Query();
		query.addCriteria(Criteria.where("evaluaciones.calificacion").lte(8.9));
		System.out.println("Alumnos con alguna calificación menor o igual a 8.9");
		mongoTemplate.find(query, Alumno.class).forEach(System.out::println);

		query = new Query();
		query.addCriteria(Criteria.where("edad.anios").lt(25));
		System.out.println("Alumnos menores de 25 años");
		mongoTemplate.find(query, Alumno.class).forEach(System.out::println);

		query = new Query();
		query.addCriteria(Criteria.where("paterno").regex(".MAR.","i"));
		System.out.println("Alumnos que contengan MAR en su apellido");
		mongoTemplate.find(query, Alumno.class).forEach(System.out::println);

		query = new Query();
		query.addCriteria(Criteria.where("evaluaciones").exists(false));
		System.out.println("Alumnos que no tengan campos evaluaciones");
		mongoTemplate.find(query, Alumno.class).forEach(
				alumno -> {
					if (alumno.getEvaluaciones() == null){
						System.out.println(alumno);
					}
				}
		);
	}



	@Test
	void insertarUnoTest() {
		System.out.println(ALUMNO);
		System.out.println("insertar Alumno");

		Alumno alumno = new Alumno(MATRICULA, "ALEJANDRO", "NOYOLA", new Date(), 1.78);
		alumno.setEdad(new Edad(47, 8, 3));
		alumno.setId(ID);
		List<Evaluacion> evaluacions = new ArrayList<Evaluacion>();
		evaluacions.add(new Evaluacion("JAVA", 9.3, new Date()));
		evaluacions.add(new Evaluacion("SPRING", 6.3, new Date()));
		evaluacions.add(new Evaluacion("POO", 7.7, new Date()));

		alumno.setEvaluaciones(evaluacions);
		repositorioAlumno.save(alumno);
		System.out.println("Total de ALUMNOS  EN MONGODB" + repositorioAlumno.count());
		repositorioAlumno.findAll().forEach(System.out::println);
	}

	@Test
	void buscarTodosMateriaTest() {
		System.out.println(ALUMNO);
		System.out.println("BUSCAR MATERIAS CON MONGODB");
		repositorioMateria.findAll().forEach(System.out::println);
	}


	@Test
	void  mongoTemplateMateriasTest(){
		System.out.println(ALUMNO);
		System.out.println("Mongo Template Insertar");

		Materia materia = new Materia(CLAVE_MATERIA, 5.0);

		mongoTemplate.insert(materia);

		System.out.println("Total de alumnos en MongoDB " + repositorioMateria.count());
		repositorioMateria.findAll().forEach(System.out::println);
	}


	@Test
	void insertarMateriaTest() {
		System.out.println(ALUMNO);
		System.out.println("insertar Materia");

		Materia materia = new Materia(CLAVE_MATERIA, 5.00);
		materia.setDetalles(new Detalles("Ciencias Exactas", "2020-0"));
		materia.setId(ID);
		List<Tema> temas = new ArrayList<Tema>();
		temas.add(new Tema("Álgebra", 5.0));
		temas.add(new Tema("Geometría", 3.0));


		materia.setTema(temas);
		repositorioMateria.save(materia);
		System.out.println("Total de MATERIAS EN MONGODB" + repositorioMateria.count());
		repositorioMateria.findAll().forEach(System.out::println);
	}




	@Test
	void buscarMongoTemplateMateriaTest() {
		System.out.println(ALUMNO);
		System.out.println("Buscar con MongoTemplate criteria");

		// Consultar por clave_materia
		Query query = new Query();
		query.addCriteria(Criteria.where("clave_materia").is("MAT101"));
		System.out.println("Materias con clave MAT101");
		mongoTemplate.find(query, Materia.class).forEach(System.out::println);


		// Consultar por nombre de materia
		query = new Query();
		query.addCriteria(Criteria.where("materia").gt("Matemáticas Básicas"));
		System.out.println("Materias con el nombre Matemáticas Básicas");
		mongoTemplate.find(query, Materia.class).forEach(System.out::println);

		// Consultar por créditos
		query = new Query();
		query.addCriteria(Criteria.where("creditos").gt(5.0));
		System.out.println("Materias con creditos mayor a 5.0");
		mongoTemplate.find(query, Materia.class).forEach(System.out::println);

		// Consultar por horas
		query = new Query();
		query.addCriteria(Criteria.where("horas").lt(60.0));
		System.out.println("Materias con horas mayor a 60.0");
		mongoTemplate.find(query, Materia.class).forEach(System.out::println);

		// Consultar por puntos
		query = new Query();
		query.addCriteria(Criteria.where("temas.puntos").lte(5.0));
		System.out.println("Materias con alguna puntos menor o igual a 5.0");
		mongoTemplate.find(query, Materia.class).forEach(System.out::println);


	}

}
