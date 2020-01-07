-- Include table data insertion, updation, deletion and select scripts

insert into `truyum`.`menu_item` 
    values(1, 'Sandwich', 99.00, 'Yes', '2017-03-15', 'Main Course', 'Yes'),
    (2, 'Burger', 129.00, 'Yes', '2017-12-23', 'Main Course', 'No'),
    (3, 'Pizza', 149.00, 'Yes', '2017-08-21', 'Main Course', 'No'),
    (4, 'French Fries', 57.00, 'No', '2017-07-02', 'Starters', 'Yes'),
    (5, 'Chocolate Brownie', 32.00, 'Yes', '2022-11-02', 'Dessert', 'Yes');
    
select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery 
    from `truyum`.`menu_item`;
 
 
select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery 
    from `truyum`.`menu_item`  
    where me_active = 'Yes'  
    and  me_date_of_launch < NOW() 
    or me_date_of_launch = NOW();


select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery 
    from `truyum`.`menu_item` 
    where me_id = 1;
    
update `truyum`.`menu_item` 
    set me_name = 'Hot Dog', me_price = 99.00, me_active = 'Yes', me_date_of_launch = '2017-03-15', me_category = 'Main Course', me_free_delivery = 'Yes' 
    where me_id = 1;


insert into `truyum`.`user`
    values(1, 'Archana'), (2, 'Divya');
    
insert into `truyum`.`cart`
    values(1, 1, 1), (2, 1, 2), (3, 1, 3);


select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery 
    from `truyum`.`cart` 
    inner join `truyum`.`menu_item` 
    on ct_pr_id = me_id 
    where ct_us_id = 1;
    
select sum(me_price) as total 
    from `truyum`.`cart`
    inner join `truyum`.`menu_item` 
    on ct_pr_id = me_id 
    where ct_us_id = 1;
    
delete from `truyum`.`cart`
    where ct_us_id = 1 
    and ct_pr_id = 3;
