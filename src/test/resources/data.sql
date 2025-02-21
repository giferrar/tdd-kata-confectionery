INSERT INTO CAKE (id, name, ingredients, calories)
VALUES (1, 'Chocolate Cake', 'flour,eggs,butter,sugar,chocolate', 488),
       (2, 'Apple Cake', 'flour,eggs,butter,sugar,apples,lemon', 298),
       (3, 'Tiramisu', 'mascarpone,eggs,sugar,savoiardi,coffee', 670),
       (4, 'Strawberry Cake', 'flour,eggs,butter,sugar,strawberries', 488),
       (5, 'Vegan Custard', 'rice milk,maizena,sugar,vanilla', 224);

drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1000 increment by 1;
