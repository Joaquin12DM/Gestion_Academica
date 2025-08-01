Use bd_gestion_academica;

INSERT INTO estudiante (nombre, email, matricula) VALUES
('Joaquin', 'joaquin@gmail.com', '202502'),
('Wilson', 'wilson@gmail.com', '202502'),
('Yorky', 'yorky@gmail.com', '202502'),
('Pilar', 'pilar@gmail.com', '202502'),
('Pierre', 'pierre@gmail.com', '202502'),
('Edson', 'edson@gmail.com', '202502'),
('Francisco', 'francisco@gmail.com', '202502'),
('Sedano', 'sedano@gmail.com', '202502'),
('Fanny', 'fanny@gmail.com', '202502'),
('Cristell', 'cristell@gmail.com', '202502'),
('Luis', 'luis@gmail.com', '202502'),
('Claudia', 'claudia@gmail.com', '202502'),
('Cristian', 'cristian@gmail.com', '202502'),
('Felix', 'felix@gmail.com', '202502'),
('Jose', 'jose@gmail.com', '202502');


INSERT INTO profesor (nombre, especialidad) VALUES
('Roberto', 'Matemáticas'),
('Cecilia', 'Física'),
('Hector', 'Química'),
('Patricia', 'Lengua y Literatura'),
('Gustavo', 'Historia'),
('Lucía', 'Biología'),
('Eduardo', 'Educación Física'),
('Verónica', 'Filosofía'),
('Raúl', 'Computación'),
('Diana', 'Inglés'),
('Oscar', 'Economía'),
('María', 'Arte'),
('José', 'Geografía'),
('Adriana', 'Psicología'),
('Alberto', 'Música');


INSERT INTO curso (nombre, codigo, creditos) VALUES
('Matemáticas I', 'MAT101', 4),
('Física General', 'FIS102', 4),
('Química Orgánica', 'QUI103', 4),
('Lengua y Literatura', 'LEN104', 3),
('Historia Universal', 'HIS105', 3),
('Biología Celular', 'BIO106', 4),
('Educación Física', 'EDF107', 2),
('Filosofía Moderna', 'FIL108', 3),
('Introducción a la Computación', 'COM109', 4),
('Inglés Básico', 'ING110', 3),
('Economía General', 'ECO111', 3),
('Arte y Cultura', 'ART112', 2),
('Geografía Física', 'GEO113', 3),
('Psicología Social', 'PSI114', 3),
('Música Aplicada', 'MUS115', 2);

INSERT INTO curso_profesor (curso_id, profesor_id) VALUES
(1, 1),  
(2, 2),  
(3, 3),  
(4, 4),   
(5, 5),   
(6, 6),  
(7, 7),   
(8, 8),  
(9, 9),   
(10, 10),
(11, 11),
(12, 12),
(13, 13), 
(14, 14),
(15, 15); 

INSERT INTO inscripcion (estado, fechaInscripcion, curso_id, estudiante_id) VALUES
('ACTIVO', '2025-03-01', 1, 1),
('ACTIVO', '2025-03-01', 2, 1),
('ACTIVO', '2025-03-01', 3, 1),
('ACTIVO', '2025-03-01', 1, 2),
('ACTIVO', '2025-03-01', 2, 2),
('ACTIVO', '2025-03-01', 3, 2),
('ACTIVO', '2025-03-01', 1, 3),
('ACTIVO', '2025-03-01', 2, 3),
('ACTIVO', '2025-03-01', 3, 3),
('ACTIVO', '2025-03-01', 1, 4),
('ACTIVO', '2025-03-01', 2, 4),
('ACTIVO', '2025-03-01', 3, 4),
('ACTIVO', '2025-03-01', 1, 5),
('ACTIVO', '2025-03-01', 2, 5),
('ACTIVO', '2025-03-01', 3, 5);

INSERT INTO inscripcion (estado, fechaInscripcion, curso_id, estudiante_id) VALUES
('ACTIVO', '2025-03-01', 7, 11),
('ACTIVO', '2025-03-01', 8, 11),
('ACTIVO', '2025-03-01', 9, 11),
('ACTIVO', '2025-03-01', 7, 12),
('ACTIVO', '2025-03-01', 8, 12),
('ACTIVO', '2025-03-01', 9, 12),
('ACTIVO', '2025-03-01', 7, 13),
('ACTIVO', '2025-03-01', 8, 13),
('ACTIVO', '2025-03-01', 9, 13),
('ACTIVO', '2025-03-01', 7, 14),
('ACTIVO', '2025-03-01', 8, 14),
('ACTIVO', '2025-03-01', 9, 14),
('ACTIVO', '2025-03-01', 7, 15),
('ACTIVO', '2025-03-01', 8, 15),
('ACTIVO', '2025-03-01', 9, 15);

INSERT INTO inscripcion (estado, fechaInscripcion, curso_id, estudiante_id) VALUES
('ACTIVO', '2025-06-01', 4, 6),
('ACTIVO', '2025-06-01', 5, 6),
('ACTIVO', '2025-06-01', 6, 6),
('ACTIVO', '2025-06-01', 4, 7),
('ACTIVO', '2025-06-01', 5, 7),
('ACTIVO', '2025-06-01', 6, 7),
('ACTIVO', '2025-06-01', 4, 8),
('ACTIVO', '2025-06-01', 5, 8),
('ACTIVO', '2025-06-01', 6, 8),
('ACTIVO', '2025-06-01', 4, 9),
('ACTIVO', '2025-06-01', 5, 9),
('ACTIVO', '2025-06-01', 6, 9),
('ACTIVO', '2025-06-01', 4, 10),
('ACTIVO', '2025-06-01', 5, 10),
('ACTIVO', '2025-06-01', 6, 10);





