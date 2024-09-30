Crud JPA y Oracle

Función Base De Datos

create or replace NONEDITIONABLE function asignar_comision(
    n_sales in number)
    return VARCHAR2
    is 
    n_commission number;
    begin
        case
        when n_sales > 200000 then
        n_commission := 0.2;
        when n_sales > 100000 and n_sales < 200000 then
        n_commission := 0.15;
        when  n_sales > 50000 and n_sales < 100000  then
        n_commission := 0.1;
        when n_sales > 30000 then
        n_commission := 0.05;
        else 
        n_commission := 0;
        end case;
        return 'Commission is ' || n_commission*100|| '%';
    end;
