INSERT INTO users (name, email, password, admin, confirmed) VALUES ('Fabio', 'fabiocode@gmail.com', '$2a$10$VkQsctMldlG9LJW6vV68pezIfMQd0Mu91.Kb.IaIHMkU653sgDSsm', false, true);
INSERT INTO users (name, email, password, admin, confirmed) VALUES ('Admin User', 'admin@example.com', '$2a$10$MnL34SeVKYvvE5SSvtM7wuTODgg4uzyGOfjrl0Ln4XLZE7o7w1cbm', true, false);
INSERT INTO users (name, email, password, admin, confirmed, token) VALUES ('Nuevo Usuario', 'nuevoUsuario@example.com', '$2a$10$MnL34SeVKYvvE5SSvtM7wuTODgg4uzyGOfjrl0Ln4XLZE7o7w1cbm', false, false, 'fa61ec06-cb6f-4aff-90e2-bf952d18d164');

INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Programación en Python - Desde Principiante hasta Experto', 'Curso completo que abarca todos los aspectos de la programación en Python. Desde los conceptos más básicos hasta las técnicas avanzadas y aplicaciones prácticas en el mundo real. Aprenderás a desarrollar proyectos Python desde cero y a convertirte en un experto en el lenguaje.', 24000, '2024-01-13', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FPyhton%20Curso.png?alt=media&token=2128f45d-22d9-45da-8db8-9f01e850e08c', 'Programación');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Desarrollo Web con JavaScript - Construye tu Sitio desde Cero', 'Este curso integral te guiará a través del emocionante mundo del desarrollo web con JavaScript. Aprenderás a construir sitios web dinámicos y modernos desde cero. Desde la manipulación del DOM hasta el desarrollo de aplicaciones web interactivas, este curso te proporcionará las habilidades esenciales para destacar en el desarrollo web.', 22500, '2024-01-14', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FJavaScript%20Curso.png?alt=media&token=21e81e2f-b36f-498c-bdb8-4193b49b12f8', 'Programación');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Dominando Java - Curso Completo Desde 0 para Estudiantes', 'Sumérgete en el universo de Java con este curso completo. Desde los fundamentos hasta las características avanzadas, aprenderás a desarrollar aplicaciones robustas y escalables utilizando Java. Cubriremos temas como programación orientada a objetos, colecciones, excepciones y patrones de diseño. ¡Prepárate para convertirte en un desarrollador Java experto!', 23000, '2024-01-15', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FJava%20Curso.png?alt=media&token=ebf6d868-f1c8-49c5-9fce-7e8edf964ffd', 'Programación');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('C# en Acción - Aprende Programación Orientada a Objetos', 'Descubre el fascinante mundo de C# con este curso dinámico. Desde los conceptos básicos hasta las complejidades de la programación orientada a objetos, dominarás el lenguaje C# mientras construyes aplicaciones prácticas. Obtén las habilidades esenciales para desarrollar software robusto y eficiente en C#.', 16000, '2024-01-16', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FC%23%20Curso.png?alt=media&token=03b112f5-5284-4d86-8481-d3699effb83c', 'Programación');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Ruby para Todos - Desde Novato hasta Rubyista', 'Conviértete en un maestro de Ruby con este curso comprehensivo. Desde los conceptos básicos de sintaxis hasta las técnicas avanzadas de desarrollo, este curso te llevará desde ser un novato hasta convertirte en un Rubyista experto. Explora la elegancia y la versatilidad de Ruby mientras construyes proyectos emocionantes.', 1200, '2024-01-17', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FRuby%20Curso.png?alt=media&token=2ef014b8-ac00-4515-bf26-d5b6d1687942', 'Programación');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Desarrollo iOS con Swift - Construye Apps para iPhone', 'Entra en el emocionante mundo del desarrollo de iOS con Swift. Aprenderás a construir aplicaciones nativas para iPhone desde cero. Desde la interfaz de usuario hasta la integración de API, este curso te proporcionará las habilidades esenciales para crear aplicaciones iOS atractivas y funcionales.', 2450, '2024-01-18', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FSwift%20Curso.png?alt=media&token=873c8b3c-2fa9-4e9c-9221-82e5060f65ac', 'Programación');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Kotlin: Desde el Principio a Desarrollador Android Profesional', 'Descubre Kotlin, el lenguaje de programación moderno para el desarrollo Android. Desde los fundamentos hasta las características avanzadas, este curso te preparará para crear aplicaciones Android de alta calidad utilizando Kotlin. Aprenderás las mejores prácticas y técnicas de desarrollo modernas.', 22700, '2024-01-19', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FKotlin%20Curso.png?alt=media&token=3ca7d2c4-2cf7-41ed-97d1-fed3f50305d9', 'Programación');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('HTML y CSS - Diseño Web Moderno desde Cero', 'Sumérgete en el diseño web moderno con HTML y CSS. Este curso te guiará desde los conceptos básicos hasta las técnicas avanzadas de diseño. Aprenderás a construir sitios web responsivos y atractivos mientras dominas las últimas tendencias en diseño web.', 9460, '2024-01-20', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FHTML%20y%20CSS%20Curso.png?alt=media&token=db4aa7fa-de7f-45fb-ac70-9a377e58fb84', 'Desarrollo Web');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('ReactJS Avanzado - Construyendo Interfaces Interactivas', 'Conviértete en un experto en ReactJS con este curso avanzado. Aprenderás a construir interfaces de usuario interactivas y dinámicas utilizando ReactJS. Explora conceptos avanzados como el manejo de estados, el enrutamiento y la gestión de formularios para crear aplicaciones web modernas.', 10000, '2024-01-21', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FReact%20Curso.png?alt=media&token=7fcb9fe2-0465-4a05-ab44-2612607742fb', 'Desarrollo Web');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Angular: Desarrollo de Aplicaciones Web Potentes', 'Explora el poder de Angular en este curso completo. Desde la configuración inicial hasta la creación de aplicaciones web potentes, obtendrás las habilidades necesarias para ser un desarrollador Angular eficiente. Aprenderás sobre componentes, servicios, rutas y más.', 6730, '2024-01-22', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FAngular%20Curso.png?alt=media&token=c79d35d3-0009-4cac-b726-e78b217cd87f', 'Desarrollo Web');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Vue.js desde Cero - Construye Aplicaciones Modernas', 'Descubre la simplicidad y la elegancia de Vue.js. Este curso te llevará desde los fundamentos hasta la creación de aplicaciones web modernas utilizando Vue.js. Aprenderás sobre componentes, directivas y el sistema de estado para construir aplicaciones escalables y eficientes.', 35, '2024-01-23', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'Desarrollo Web');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Node.js: Construyendo Aplicaciones Escalables', 'Domina el desarrollo de aplicaciones escalables con Node.js. Aprenderás a construir servidores eficientes y a trabajar con el ecosistema de Node.js. Desde la gestión de paquetes hasta la creación de API RESTful, este curso te preparará para ser un desarrollador Node.js competente.', 30, '2024-01-24', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'Desarrollo Web');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Django en Profundidad - Desarrollo Rápido de Aplicaciones Web', 'Explora las profundidades del desarrollo web con Django. Desde la configuración inicial hasta la creación de aplicaciones complejas, este curso te enseñará a desarrollar rápidamente aplicaciones web utilizando el framework Django de Python. Aprenderás sobre modelos, vistas, plantillas y más.', 25, '2024-01-25', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'Desarrollo Web');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Laravel Framework: Desarrollo de Aplicaciones Web con PHP Modernas', 'Descubre el framework PHP moderno con Laravel. Este curso te guiará desde los conceptos básicos hasta la creación de aplicaciones PHP modernas y eficientes. Aprenderás sobre migraciones, Eloquent ORM, rutas y controladores.', 17800, '2024-01-26', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FLaravel%20Curso.png?alt=media&token=5b7e1bff-440c-4009-afaa-a90c7eed4425', 'Desarrollo Web');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('MongoDB: Diseño de Bases de Datos NoSQL', 'Adéntrate en el mundo de las bases de datos NoSQL con MongoDB. Aprenderás a diseñar y gestionar bases de datos NoSQL eficientes utilizando MongoDB. Explora la flexibilidad y escalabilidad de MongoDB mientras desarrollas habilidades prácticas de diseño de bases de datos.', 40, '2024-01-27', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'Bases de Datos');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('MySQL desde Cero - Fundamentos de Bases de Datos Relacionales', 'Inicia tu viaje en bases de datos relacionales con MySQL. Este curso te llevará desde la instalación hasta la creación y gestión de bases de datos relacionales eficientes con MySQL. Aprenderás sobre consultas SQL, relaciones y optimización de bases de datos.', 35, '2024-01-28', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'Bases de Datos');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('PostgreSQL: Administración y Desarrollo Avanzado', 'Domina la administración y el desarrollo avanzado con PostgreSQL. Desde la instalación hasta la optimización de consultas, aprenderás a trabajar eficientemente con PostgreSQL. Explora características avanzadas como las funciones almacenadas, los disparadores y la replicación.', 30, '2024-01-29', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'Bases de Datos');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Firebase en Acción - Desarrollo de Aplicaciones en la Nube', 'Descubre el potencial de desarrollo en la nube con Firebase. Este curso te enseñará a construir aplicaciones escalables y en tiempo real utilizando Firebase. Aprenderás sobre autenticación, almacenamiento en la nube, y la integración de Firebase en aplicaciones web y móviles.', 25, '2024-01-30', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'Bases de Datos');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Docker: Despliegue y Contenerización de Aplicaciones', 'Aprende la revolucionaria tecnología de contenerización con Docker. Este curso te guiará desde la instalación hasta el despliegue de aplicaciones en contenedores Docker. Aprenderás sobre la construcción de imágenes, la orquestación de contenedores y la gestión de entornos de desarrollo.', 20, '2024-01-31', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'DevOps');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Kubernetes para Desarrolladores - Orquestación de Contenedores', 'Descubre la orquestación de contenedores con Kubernetes. Este curso te enseñará a desplegar, escalar y gestionar aplicaciones en entornos Kubernetes. Aprenderás sobre servicios, despliegues y prácticas recomendadas para el desarrollo en entornos orquestados.', 15, '2024-02-01', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'DevOps');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Jenkins: Automatización de Despliegues y CI/CD', 'Automatiza tus procesos de desarrollo con Jenkins. Desde la configuración inicial hasta la creación de tuberías de CI/CD, este curso te proporcionará las habilidades esenciales para la automatización de despliegues y la integración continua utilizando Jenkins.', 10, '2024-02-02', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'DevOps');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Git: Control de Versiones desde Principiante hasta Experto', 'Domina el control de versiones con Git. Este curso te guiará desde los conceptos básicos hasta las prácticas avanzadas de Git. Aprenderás sobre ramificaciones, fusiones, conflictos y cómo trabajar eficientemente en equipos utilizando Git.', 50, '2024-02-03', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'Control de Versiones');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('SVN: Gestión de Versiones en Proyectos de Desarrollo', 'Explora la gestión de versiones en proyectos de desarrollo con SVN. Aprenderás a configurar y utilizar SVN para gestionar eficientemente el código fuente. Desde la creación de repositorios hasta la fusión de ramas, este curso te proporcionará las habilidades necesarias para la gestión de versiones con SVN.', 40, '2024-02-04', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'Control de Versiones');
INSERT INTO courses (name, description, registered_users, publication_date, image, category) VALUES ('Desarrollo Full Stack con MERN Stack', 'Conviértete en un desarrollador Full Stack con el MERN Stack (MongoDB, Express.js, React y Node.js). Este curso te guiará a través de la creación de aplicaciones web modernas y escalables utilizando todas las tecnologías del MERN Stack. Aprenderás sobre la integración completa de las tecnologías y la construcción de aplicaciones eficientes desde el front-end hasta el back-end.', 60, '2024-02-05', 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FCurso%20Generico.png?alt=media&token=10ce507b-536c-49ff-b92d-545544f0bf2a', 'Desarrollo Web');
INSERT INTO apikeytable (api_key, uses, active, read_only) VALUES ('75gIEHhE_1GHQtdwlGRPTF1kQoZ02omTS0sfs_TX', 10000, 1, 0);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Python', 1, 1);
INSERT INTO sections (title, section_order, course_id) VALUES ('Primeros pasos', 2, 1);
INSERT INTO sections (title, section_order, course_id) VALUES ('Variables', 3, 1);
INSERT INTO sections (title, section_order, course_id) VALUES ('Condicionales', 4, 1);
INSERT INTO sections (title, section_order, course_id) VALUES ('Bucles', 5, 1);
INSERT INTO sections (title, section_order, course_id) VALUES ('Listas y tuplas', 6, 1);
INSERT INTO sections (title, section_order, course_id) VALUES ('POO', 7, 1);
INSERT INTO sections (title, section_order, course_id) VALUES ('Python avanzado', 8, 1);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a JavaScript', 1, 2);
INSERT INTO sections (title, section_order, course_id) VALUES ('Manipulación del DOM', 2, 2);
INSERT INTO sections (title, section_order, course_id) VALUES ('Desarrollo de Aplicaciones Web', 3, 2);
INSERT INTO sections (title, section_order, course_id) VALUES ('AJAX y API REST', 4, 2);
INSERT INTO sections (title, section_order, course_id) VALUES ('Frameworks de JavaScript', 5, 2);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 2);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Java', 1, 3);
INSERT INTO sections (title, section_order, course_id) VALUES ('Programación Orientada a Objetos', 2, 3);
INSERT INTO sections (title, section_order, course_id) VALUES ('Estructuras de Datos', 3, 3);
INSERT INTO sections (title, section_order, course_id) VALUES ('Desarrollo de Aplicaciones Java', 4, 3);
INSERT INTO sections (title, section_order, course_id) VALUES ('Spring Framework', 5, 3);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 3);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a C#', 1, 4);
INSERT INTO sections (title, section_order, course_id) VALUES ('Programación Orientada a Objetos con C#', 2, 4);
INSERT INTO sections (title, section_order, course_id) VALUES ('Desarrollo de Aplicaciones con C#', 3, 4);
INSERT INTO sections (title, section_order, course_id) VALUES ('ASP.NET Core', 4, 4);
INSERT INTO sections (title, section_order, course_id) VALUES ('Entity Framework', 5, 4);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 4);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Ruby', 1, 5);
INSERT INTO sections (title, section_order, course_id) VALUES ('Programación Orientada a Objetos con Ruby', 2, 5);
INSERT INTO sections (title, section_order, course_id) VALUES ('Desarrollo de Aplicaciones con Ruby', 3, 5);
INSERT INTO sections (title, section_order, course_id) VALUES ('Ruby on Rails', 4, 5);
INSERT INTO sections (title, section_order, course_id) VALUES ('Testing en Ruby', 5, 5);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 5);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Swift', 1, 6);
INSERT INTO sections (title, section_order, course_id) VALUES ('UIKit y Storyboards', 2, 6);
INSERT INTO sections (title, section_order, course_id) VALUES ('Trabajo con Datos en iOS', 3, 6);
INSERT INTO sections (title, section_order, course_id) VALUES ('Integración de API en iOS', 4, 6);
INSERT INTO sections (title, section_order, course_id) VALUES ('Desarrollo de Aplicaciones Complejas', 5, 6);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 6);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Kotlin', 1, 7);
INSERT INTO sections (title, section_order, course_id) VALUES ('Programación Orientada a Objetos con Kotlin', 2, 7);
INSERT INTO sections (title, section_order, course_id) VALUES ('Desarrollo Android con Kotlin', 3, 7);
INSERT INTO sections (title, section_order, course_id) VALUES ('Interfaz de Usuario en Android', 4, 7);
INSERT INTO sections (title, section_order, course_id) VALUES ('Almacenamiento y Red en Android', 5, 7);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 7);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a HTML', 1, 8);
INSERT INTO sections (title, section_order, course_id) VALUES ('Fundamentos de CSS', 2, 8);
INSERT INTO sections (title, section_order, course_id) VALUES ('Diseño Responsivo', 3, 8);
INSERT INTO sections (title, section_order, course_id) VALUES ('Flexbox y Grid', 4, 8);
INSERT INTO sections (title, section_order, course_id) VALUES ('Animaciones y Transiciones', 5, 8);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 8);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a ReactJS', 1, 9);
INSERT INTO sections (title, section_order, course_id) VALUES ('Componentes y Props', 2, 9);
INSERT INTO sections (title, section_order, course_id) VALUES ('Estado y Ciclo de Vida', 3, 9);
INSERT INTO sections (title, section_order, course_id) VALUES ('Manejo de Eventos en React', 4, 9);
INSERT INTO sections (title, section_order, course_id) VALUES ('Enrutamiento en React', 5, 9);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 9);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Angular', 1, 10);
INSERT INTO sections (title, section_order, course_id) VALUES ('Componentes y Directivas', 2, 10);
INSERT INTO sections (title, section_order, course_id) VALUES ('Servicios y Inyección de Dependencias', 3, 10);
INSERT INTO sections (title, section_order, course_id) VALUES ('Rutas y Navegación', 4, 10);
INSERT INTO sections (title, section_order, course_id) VALUES ('Formularios en Angular', 5, 10);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 10);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Vue.js', 1, 11);
INSERT INTO sections (title, section_order, course_id) VALUES ('Componentes y Propiedades', 2, 11);
INSERT INTO sections (title, section_order, course_id) VALUES ('Estado y Eventos', 3, 11);
INSERT INTO sections (title, section_order, course_id) VALUES ('Directivas en Vue.js', 4, 11);
INSERT INTO sections (title, section_order, course_id) VALUES ('Rutas en Vue.js', 5, 11);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 11);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Node.js', 1, 12);
INSERT INTO sections (title, section_order, course_id) VALUES ('Express.js: Desarrollo de Aplicaciones Web', 2, 12);
INSERT INTO sections (title, section_order, course_id) VALUES ('Trabajo con Bases de Datos en Node.js', 3, 12);
INSERT INTO sections (title, section_order, course_id) VALUES ('API RESTful con Node.js', 4, 12);
INSERT INTO sections (title, section_order, course_id) VALUES ('Autenticación y Autorización', 5, 12);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 12);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Django', 1, 13);
INSERT INTO sections (title, section_order, course_id) VALUES ('Modelos y Vistas en Django', 2, 13);
INSERT INTO sections (title, section_order, course_id) VALUES ('Plantillas y Formularios', 3, 13);
INSERT INTO sections (title, section_order, course_id) VALUES ('Admin y Middleware', 4, 13);
INSERT INTO sections (title, section_order, course_id) VALUES ('APIs en Django', 5, 13);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 13);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Laravel', 1, 14);
INSERT INTO sections (title, section_order, course_id) VALUES ('Migraciones y Eloquent ORM', 2, 14);
INSERT INTO sections (title, section_order, course_id) VALUES ('Rutas y Controladores', 3, 14);
INSERT INTO sections (title, section_order, course_id) VALUES ('Vistas y Blade', 4, 14);
INSERT INTO sections (title, section_order, course_id) VALUES ('Autenticación en Laravel', 5, 14);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 14);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a MongoDB', 1, 15);
INSERT INTO sections (title, section_order, course_id) VALUES ('Operaciones CRUD en MongoDB', 2, 15);
INSERT INTO sections (title, section_order, course_id) VALUES ('Índices y Agregaciones', 3, 15);
INSERT INTO sections (title, section_order, course_id) VALUES ('Modelado de Datos en MongoDB', 4, 15);
INSERT INTO sections (title, section_order, course_id) VALUES ('Replicación y Fragmentación', 5, 15);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 15);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a MySQL', 1, 16);
INSERT INTO sections (title, section_order, course_id) VALUES ('Consultas SQL Avanzadas', 2, 16);
INSERT INTO sections (title, section_order, course_id) VALUES ('Optimización de Bases de Datos', 3, 16);
INSERT INTO sections (title, section_order, course_id) VALUES ('Relaciones y Claves Extranjeras', 4, 16);
INSERT INTO sections (title, section_order, course_id) VALUES ('Procedimientos Almacenados', 5, 16);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 16);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a PostgreSQL', 1, 17);
INSERT INTO sections (title, section_order, course_id) VALUES ('Optimización de Consultas', 2, 17);
INSERT INTO sections (title, section_order, course_id) VALUES ('Funciones Almacenadas y Triggers', 3, 17);
INSERT INTO sections (title, section_order, course_id) VALUES ('Replicación y Particionamiento', 4, 17);
INSERT INTO sections (title, section_order, course_id) VALUES ('Seguridad en PostgreSQL', 5, 17);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 17);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Firebase', 1, 18);
INSERT INTO sections (title, section_order, course_id) VALUES ('Autenticación y Autorización en Firebase', 2, 18);
INSERT INTO sections (title, section_order, course_id) VALUES ('Almacenamiento en la Nube con Firebase', 3, 18);
INSERT INTO sections (title, section_order, course_id) VALUES ('Base de Datos en Tiempo Real', 4, 18);
INSERT INTO sections (title, section_order, course_id) VALUES ('Notificaciones y Funciones en la Nube', 5, 18);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 18);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Docker', 1, 19);
INSERT INTO sections (title, section_order, course_id) VALUES ('Creación de Imágenes Docker', 2, 19);
INSERT INTO sections (title, section_order, course_id) VALUES ('Orquestación con Docker Compose', 3, 19);
INSERT INTO sections (title, section_order, course_id) VALUES ('Redes y Volúmenes en Docker', 4, 19);
INSERT INTO sections (title, section_order, course_id) VALUES ('Docker Swarm y Escalabilidad', 5, 19);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 19);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Kubernetes', 1, 20);
INSERT INTO sections (title, section_order, course_id) VALUES ('Despliegue de Aplicaciones en Kubernetes', 2, 20);
INSERT INTO sections (title, section_order, course_id) VALUES ('Escalabilidad y Actualizaciones', 3, 20);
INSERT INTO sections (title, section_order, course_id) VALUES ('Servicios y Redes en Kubernetes', 4, 20);
INSERT INTO sections (title, section_order, course_id) VALUES ('Monitoreo y Solución de Problemas', 5, 20);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 20);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Jenkins', 1, 21);
INSERT INTO sections (title, section_order, course_id) VALUES ('Configuración y Creación de Pipelines', 2, 21);
INSERT INTO sections (title, section_order, course_id) VALUES ('Despliegue Continuo con Jenkins', 3, 21);
INSERT INTO sections (title, section_order, course_id) VALUES ('Gestión de Configuración', 4, 21);
INSERT INTO sections (title, section_order, course_id) VALUES ('Integración con Herramientas Externas', 5, 21);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 21);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a Git', 1, 22);
INSERT INTO sections (title, section_order, course_id) VALUES ('Trabajo con Ramas en Git', 2, 22);
INSERT INTO sections (title, section_order, course_id) VALUES ('Resolución de Conflictos en Git', 3, 22);
INSERT INTO sections (title, section_order, course_id) VALUES ('Flujo de Trabajo en Equipos', 4, 22);
INSERT INTO sections (title, section_order, course_id) VALUES ('Git Avanzado y Buenas Prácticas', 5, 22);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 22);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción a SVN', 1, 23);
INSERT INTO sections (title, section_order, course_id) VALUES ('Configuración de Repositorios SVN', 2, 23);
INSERT INTO sections (title, section_order, course_id) VALUES ('Trabajo con Ramas en SVN', 3, 23);
INSERT INTO sections (title, section_order, course_id) VALUES ('Fusiones y Resolución de Conflictos', 4, 23);
INSERT INTO sections (title, section_order, course_id) VALUES ('Propiedades y Etiquetas en SVN', 5, 23);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 23);

INSERT INTO sections (title, section_order, course_id) VALUES ('Introducción al MERN Stack', 1, 24);
INSERT INTO sections (title, section_order, course_id) VALUES ('Desarrollo Front-end con React', 2, 24);
INSERT INTO sections (title, section_order, course_id) VALUES ('Desarrollo Back-end con Node.js y Express', 3, 24);
INSERT INTO sections (title, section_order, course_id) VALUES ('Base de Datos MongoDB con Mongoose', 4, 24);
INSERT INTO sections (title, section_order, course_id) VALUES ('Integración Completa del MERN Stack', 5, 24);
INSERT INTO sections (title, section_order, course_id) VALUES ('Proyecto Final', 6, 24);

INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Historia del lenguaje', 1, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 1);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Instalando PyCharm', 1, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 2);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Hola Mundo en Python', 2, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 2);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Introducción a JavaScript', 1, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 9);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Manipulación del DOM con JS', 2, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 10);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Introducción a Java', 1, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 15);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Programación Orientada a Objetos', 2, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 16);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Introducción a C#', 1, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 21);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Programación Orientada a Objetos con C#', 2, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 22);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Sintaxis Básica de Ruby', 1, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 27);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Programación Orientada a Objetos en Ruby', 2, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 28);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Introducción a Kotlin', 1, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 39);
INSERT INTO lessons (name, lesson_order, video, section_id) VALUES ('Programación Orientada a Objetos en Kotlin', 2, 'https://firebasestorage.googleapis.com/v0/b/fabiocodeacademy.appspot.com/o/CoursesImages%2FVideo%20de%20Presentacion.mp4?alt=media&token=0ab1007e-008f-42e2-86d9-2f50f3c5ba55', 40);

INSERT INTO users_courses (course_id,user_id) VALUES (4,1)
INSERT INTO users_courses (course_id,user_id) VALUES (3,1)
INSERT INTO users_courses (course_id,user_id) VALUES (10,1)
INSERT INTO users_courses (course_id,user_id) VALUES (10,2)