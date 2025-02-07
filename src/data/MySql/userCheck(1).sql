drop procedure if exists userCheck;
delimiter //

create procedure userCheck(
in in_email varchar (30), in in_lösenord varchar (30), 
out out_personnummer varchar(13), out out_förnamn varchar (30), out out_efternamn varchar (30))

begin

declare wrongInlog tinyint default 0; -- så den inte sätter null.

-- kolla att email och lösenord matchar
select count(*) into wrongInlog from Kund
where Kund.email = in_email and Kund.lösenord = in_lösenord;

-- kolla om inlogg lyckades
if wrongInlog > 0 then 
select Kund.personnummer, Kund.förnamn, Kund.efternamn
into out_personnummer, out_förnamn, out_efternamn from kund 
where  email = in_email and lösenord = in_lösenord;
-- limit 1;
else
set out_personnummer = '0000000000000';
set out_förnamn = 'error.förnamn';
set out_efternamn = 'error.efternamn';
end if;

end //

delimiter ;

commit