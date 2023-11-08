INSERT IGNORE INTO `empresas` (`id`,`nombre`,`telefono`,`email`) VALUES
(1,'ISSARD','932222251','ISSARD@GMAIL.COM'),
(2, 'GLOBEX', '912345678', 'GLOBEX@GMAIL.COM'),
(3, 'XYZ Company', '987654321', 'XYZ@COMPANY.COM'),
(4, 'ACME Inc.', '900112233', 'ACME@EXAMPLE.COM'),
(5, 'Initech', '933344455', 'INITECH@EMAIL.COM'),
(6, 'TechCorp', '944556677', 'TECHCORP@MAIL.COM'),
(7, 'Cyber Systems', '955667788', 'CYBER@SYSTEMS.COM'),
(8, 'MegaCorp', '966778899', 'MEGA@CORP.COM'),
(9, 'Alpha Enterprises', '977889900', 'ALPHA@ENTERPRISES.COM'),
(10, 'Beta Industries', '988990011', 'BETA@INDUSTRIES.COM'),
(11, 'Gamma Ltd.', '990001122', 'GAMMA@LTD.COM'),
(12, 'Delta Solutions', '901112233', 'DELTA@SOLUTIONS.COM'),
(13, 'Omega Technologies', '912223344', 'OMEGA@TECH.COM'),
(14, 'Sigma Innovations', '923334455', 'SIGMA@INNOVATIONS.COM'),
(15, 'Zeta Corporation', '934445566', 'ZETA@CORP.COM');

INSERT IGNORE INTO `ofertas` (`id`,`descripcion`,`requisitos`,`salario`,`empresa_id`) values
(1,'desc1','req1',30000, 3),
(2,'desc2','req2',60000, 1),
(3,'desc3','req3',10000, 4),
(4,'desc4','req4',120000, 7),
(5,'desc5','req5',4000, 12),
(6,'desc6','req6',360000, 3);



INSERT IGNORE INTO `usuarios` (`id`,`usuario`,`password`) VALUES (1,'admin','456'), (2,'itic','itic');


