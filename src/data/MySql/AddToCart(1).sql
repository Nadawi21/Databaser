

drop procedure if exists AddToCart;
delimiter //
create procedure AddToCart (IN customerId varchar(13), productId int, orderId int, orderDate DATE, quantity int)

begin 
-- variabler som ska innehålla de befintliga värdena
declare currentOrderId int; 
declare currentQuantity int;
declare activeOrderId int;
declare availableQuantity int;
declare productQuantityId int;

-- Sätter värden till variablerna till att kolla att lagret inte tar slut 
-- joinar produkt och lager saldo
select Lagersaldo.LagerId, Lagersaldo.Kvantitet 
into productQuantityId, availableQuantity
from Produkt join Lagersaldo on Produkt.LagerIdFK = Lagersaldo.lagerId
where Produkt.produktId = productId;

-- Error slut i lager
if availableQuantity < quantity then 
	signal sqlstate '45000' set message_text = 'the product is out of stock';
	
end if;

-- kolla om personnummer och ordern är aktiv
select BeställningsId into activeOrderId from Beställning
where personnummerFK = customerId and status = 'active'
LIMIT 1;

-- kontrollerar om orderna är aktiva, och isf använd den. annars skapa en ny.
if activeOrderId is not null then
	set currentOrderId = activeOrderId;
	else 
	insert into Beställning (personnummerFK, datum, status) 
	values (customerId, orderDate, 'active');
	set currentOrderId = LAST_INSERT_ID();
end if;

-- uppdaterar antalet i ordern om man lägger till samma produkt i samma beställning
if exists (select * from Kundorder where beställningsidFK = currentOrderId and produktIdFK = productId) then
-- om produkten existerar uppdateras kvanititetn
select antal into currentQuantity from kundorder where beställningsidFK = currentOrderId and produktIdFK = productId;
update kundorder set  antal = currentQuantity + quantity  where beställningsidFK = currentOrderId and produktIdFK = productId;
else
-- insertar i kundorder om det är nya värden produkt och antal (inga dubletter av exakt likadana rader ska förekomma)
    insert into kundorder (beställningsidFK, produktIdFK, antal) values ( currentOrderId, productId, quantity);
end if;

update Lagersaldo
set Kvantitet = Kvantitet - quantity
where Lagerid = productQuantityId;

end//

delimiter ;


-- Det skapas upp en ny beställning
call AddToCart('19581113-4031',1, null,'2023-02-07',2);

-- En vara läggs till i en befintlig beställning
-- En vara som redan finns i en beställning ökas på, i antal, i beställningen.
call AddToCart('19581113-4031',2, 8,'2023-02-07',2);



-- kontrollera tabelelrna 
select*from beställning;
select*from kundorder;
select*from lagersaldo;

commit;

