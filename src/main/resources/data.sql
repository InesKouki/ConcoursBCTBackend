INSERT IGNORE INTO `roles`(`id`, `name`) VALUES (1,'ROLE_USER');
INSERT IGNORE INTO `roles`(`id`, `name`) VALUES (2,'ROLE_ADMIN');
INSERT IGNORE INTO `roles`(`id`, `name`) VALUES (3,'ROLE_RH'); 

INSERT IGNORE INTO `users`(`cin`, `code`, `confirmed`, `cv`, `date_naissance`, `email`, `nom`, `password`, `prenom`, `sexe`, `username`) VALUES ('12345678','F9FLRE',true,null,null,'testrhtest@test.test','Foulen','$2a$10$XyXFzRcZCawnUtNNQMhS3.z4DgFbWa4vlnkVnLdIUQLbndt3a9gFy','Ben Falten','Homme','testrh');
INSERT IGNORE INTO `user_roles`(`user_id`, `role_id`) SELECT users.id,2 FROM `users` WHERE users.username='testadmin';
INSERT IGNORE INTO `users`(`cin`, `code`, `confirmed`, `cv`, `date_naissance`, `email`, `nom`, `password`, `prenom`, `sexe`, `username`) VALUES ('15987654','98F41R',true,null,null,'testadmintest@test.test','Ahmed','$2a$10$XyXFzRcZCawnUtNNQMhS3.z4DgFbWa4vlnkVnLdIUQLbndt3a9gFy','Ben Salem','Homme','testadmin');
INSERT IGNORE INTO `user_roles`(`user_id`, `role_id`) SELECT users.id,3 FROM `users` WHERE users.username='testrh';
