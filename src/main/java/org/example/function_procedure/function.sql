CREATE OR REPLACE FUNCTION public.cuentaEjercicios()
    RETURNS int
	LANGUAGE plpgsql
AS $$
declare
   contador integer;
	BEGIN
		select count(*) into contador from Ejercicios;
        return contador;
	END;
$$;

