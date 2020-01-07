-- Include table data insertion, updation, deletion and select scripts

insert into `truyum`.`menu_item` 
    values(1, 'Sandwich', 99.00, 'Yes', '2017-03-15', 'Main Course', 'Yes','https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1353&q=80'),
    (2, 'Burger', 129.00, 'Yes', '2017-12-23', 'Main Course', 'No','https://images.unsplash.com/photo-1512152272829-e3139592d56f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'),
    (3, 'Pizza', 149.00, 'Yes', '2017-08-21', 'Main Course', 'No','https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'),
    (4, 'French Fries', 57.00, 'No', '2017-07-02', 'Starters', 'Yes','https://images.unsplash.com/photo-1526230427044-d092040d48dc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60'),
    (5, 'Chocolate Brownie', 32.00, 'Yes', '2022-11-02', 'Dessert', 'Yes','https://images.unsplash.com/photo-1564355808539-22fda35bed7e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
    

insert into  `truyum`.`user` 
     values (1, 'user','user','user','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');

insert into  `truyum`.`user` 
     values (2, 'admin','admin','admin','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');


insert into `truyum`.`role` values (1, 'USER');

insert into `truyum`.`role` values (2, 'ADMIN');


insert into `truyum`.`user_role` values (1, 1, 1);

insert into `truyum`.`user_role` values (2, 2, 2);

    
insert into `truyum`.`cart`
    values(1, 1, 1), (2, 1, 2), (3, 1, 3);




