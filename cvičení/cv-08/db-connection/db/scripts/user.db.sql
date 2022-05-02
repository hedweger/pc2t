BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `user_has_role` (
	`user_id_user`	INTEGER,
	`role_id_role`	INTEGER,
	FOREIGN KEY(`role_id_role`) REFERENCES `role`(`id_role`),
	FOREIGN KEY(`user_id_user`) REFERENCES `user`(`id_user`)
);
INSERT INTO `user_has_role` VALUES (1,1);
INSERT INTO `user_has_role` VALUES (2,1);
INSERT INTO `user_has_role` VALUES (3,2);
CREATE TABLE IF NOT EXISTS `user` (
	`id_user`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`email`	TEXT NOT NULL UNIQUE,
	`name`	TEXT NOT NULL,
	`surname`	TEXT NOT NULL,
	`age`	INTEGER,
	`salary`	INTEGER
);
INSERT INTO `user` VALUES (1,'myname@stud.feec.vutbr.cz','AnonymousName','AnonymousSurname',22,30000);
INSERT INTO `user` VALUES (2,'student@vutbr.cz','studentName','studentSurname',21,10000);
INSERT INTO `user` VALUES (3,'admin@vutbr.cz','adminName','adminSurname',44,50000);
CREATE TABLE IF NOT EXISTS `role` (
	`id_role`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`name`	INTEGER NOT NULL UNIQUE
);
INSERT INTO `role` VALUES (1,'USER');
INSERT INTO `role` VALUES (2,'ADMIN');
INSERT INTO `role` VALUES (3,'MANAGER');
COMMIT;
